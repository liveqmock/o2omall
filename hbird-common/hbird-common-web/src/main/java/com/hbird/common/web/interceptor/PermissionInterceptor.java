package com.hbird.common.web.interceptor;

import java.net.MalformedURLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.method.HandlerMethod;

import com.hbird.common.web.annotation.Permission;
import com.hbird.common.web.context.ExcludeRequstPath;
import com.hbird.common.web.context.UserContext;
import com.hbird.common.web.url.UrlBuilder.Builder;
import com.hbird.common.web.url.UrlBuilders;
import com.hbird.portal.sdk.PermissionClient;
import com.hbird.portal.sdk.request.PermissionCheckRequest;

/**
 * 用户访问授权的拦截器，基于权限系统的资源码<br/>
 * 主要作用：<br/>
 * 拦截用户请求，获取并解析登录的用户cookie；<br/>
 * 判断用户是否有权限访问，如果没权限，则跳转到没权限的界面。
 * 
 * @see com.hbird.common.web.context.LoginUser
 * @see com.hbird.common.web.context.UserContext
 * @see com.hbird.common.web.annotation.Permission
 * 
 * @author lz
 * 
 */
public class PermissionInterceptor extends AbstractHandlerInterceptorAdapter {

    protected PermissionClient permissionClient;
    protected UrlBuilders urlBuilders;
    protected String noPermissionUrl = "noPermissionUrl";

    private final static Log LOG = LogFactory.getLog(PermissionInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        if (ExcludeRequstPath.isExclude(getExcludePaths(), uri)) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("in request [" + uri + "], this url is excludeRequstPath");
            }
            return true;
        }

        UserContext context = UserContext.get();
        if (context == null || !context.isLogin()) {// 没登录
            LOG.warn("用户没登录");
            return false;
        }

        Long userId = context.getUserId();

        try {
            if (null != handler && handler.getClass().isAssignableFrom(HandlerMethod.class)) {
                Permission authPassport = ((HandlerMethod) handler).getMethodAnnotation(Permission.class);
                // 没有声明需要权限,或者声明不验证权限
                if (authPassport != null && authPassport.value() != null) {
                    String resourceCode = authPassport.value();
                    // 权限验证逻辑:基于权限资源码
                    PermissionCheckRequest checkRequest = new PermissionCheckRequest();
                    checkRequest.setUserId(userId);
                    checkRequest.setResourceCode(resourceCode);
                    Boolean result = permissionClient.isPermitted(checkRequest);

                    if (null == result || !result) { // 如果验证失败，跳转到无权限访问资源的错误提示界面
                        LOG.warn("用户[" + context.getUserName() + "]没权限访问资源" + resourceCode);
                        response.sendRedirect(getNoPermissionUrl(userId, resourceCode));
                        return false;
                    } else {
                        LOG.info("用户[" + context.getUserName() + "]可以访问资源" + resourceCode);
                    }
                }
            }
        } catch (Exception e) {
            LOG.warn("PermissionInterceptor has error,", e);
        }
        return true;
    }

    /**
     * 获取没权限操作的URL
     * 
     * @param userId
     * @param resourceCode
     * @return
     * @throws MalformedURLException
     */
    protected String getNoPermissionUrl(Long userId, String resourceCode) throws MalformedURLException {
        Builder noPermissionUrlBuilder = urlBuilders.get(noPermissionUrl).forPath(null);
        noPermissionUrlBuilder.put("userId", userId);
        noPermissionUrlBuilder.put("resourceCode", resourceCode);
        return noPermissionUrlBuilder.build();
    }

    /**
     * @param permissionClient
     *            the permissionClient to set
     */
    public void setPermissionClient(PermissionClient permissionClient) {
        this.permissionClient = permissionClient;
    }

    /**
     * @param urlBuilders
     *            the urlBuilders to set
     */
    public void setUrlBuilders(UrlBuilders urlBuilders) {
        this.urlBuilders = urlBuilders;
    }

    /**
     * @param noPermissionUrl
     *            the noPermissionUrl to set
     */
    public void setNoPermissionUrl(String noPermissionUrl) {
        this.noPermissionUrl = noPermissionUrl;
    }
}
