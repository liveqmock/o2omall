package com.hbird.common.web.interceptor;

import java.net.MalformedURLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.method.HandlerMethod;

import com.hbird.common.web.annotation.Permission;
import com.hbird.common.web.context.ExcludeRequstPath;
import com.hbird.common.web.context.UserContext;
import com.hbird.common.web.url.UrlBuilder;
import com.hbird.common.web.url.UrlBuilder.Builder;
import com.hbird.common.web.url.UrlBuilders;
import com.hbird.portal.sdk.PermissionClient;
import com.hbird.portal.sdk.request.PermissionCheckRequest;

/**
 * 用户访问授权的拦截器，基于权限系统的资源码或者请求的URL。<br/>
 * 主要作用：<br/>
 * 拦截用户请求，获取并解析登录的用户cookie；<br/>
 * 判断用户是否有权限访问，如果没权限，则跳转到没权限的界面。
 * 
 * @see com.hbird.common.web.context.LoginUser
 * @see com.hbird.common.web.context.UserContext
 * @see com.hbird.common.web.annotation.Permission
 * 
 * @author ljz
 * 
 */
public class UrlPermissionInterceptor extends AbstractHandlerInterceptorAdapter {

    protected PermissionClient permissionClient;
    protected UrlBuilders urlBuilders;

    protected String noPermissionUrl = "noPermissionUrl";
    /** 特殊参数 UID */
    protected String SPECIAL_PARAM_UID = "UID";

    private final static Log LOG = LogFactory.getLog(UrlPermissionInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        if (ExcludeRequstPath.isExclude(getExcludePaths(), uri)) {
            LOG.debug("in request [" + uri + "], this url is excludeRequstPath");
            return true;
        }

        UserContext context = UserContext.get();
        if (context == null || !context.isLogin()) {// 没登录
            LOG.warn("用户没登录");
            return false;
        }

        boolean result = false;
        String resource = null;
        Long userId = context.getUserId();

        try {
            if (null != handler && handler.getClass().isAssignableFrom(HandlerMethod.class)) {
                Permission authPassport = ((HandlerMethod) handler).getMethodAnnotation(Permission.class);
                PermissionCheckRequest checkRequest = new PermissionCheckRequest();
                checkRequest.setUserId(userId);

                if (authPassport != null && authPassport.value() != null) {
                    resource = authPassport.value();
                    // 权限验证逻辑:基于权限资源码
                    checkRequest.setResourceCode(resource);
                } else {
                    resource = request.getRequestURL().toString();
                    // 权限验证逻辑：基于URL
                    checkRequest.setResourceUrl(resource);
                }
                result = permissionClient.isPermitted(checkRequest);
            }
        } catch (Exception e) {
            LOG.warn("PermissionInterceptor has error,", e);
        }

        if (!result) { // 如果验证失败，跳转到无权限访问资源的错误提示界面
            LOG.warn("用户[" + context.getUserName() + "]没权限访问资源" + resource);
            response.sendRedirect(getNoPermissionUrl(context.getUserName(), resource));
            return false;
        } else {
            LOG.debug("用户[" + context.getUserName() + "]可以访问资源" + resource);
            return true;
        }
    }

    /**
     * @param request
     * @return
     * @throws MalformedURLException
     */
    @SuppressWarnings("unchecked")
    protected String getFullRequestURL(HttpServletRequest request) throws MalformedURLException {
        String baseUrl = request.getRequestURL().toString();
        UrlBuilder urlBuilder = new UrlBuilder(baseUrl);
        Builder builder = urlBuilder.forPath(null);

        Map<String, Object> parameterMap = request.getParameterMap();
        for (Map.Entry<String, Object> entry : parameterMap.entrySet()) {
            // 如果依据url判断权限，需要过滤掉UID
            if (!SPECIAL_PARAM_UID.equals(entry.getKey())) {
                builder.put(entry.getKey(), entry.getValue());
            }
        }

        return builder.build();
    }

    /**
     * 获取没权限操作的URL
     * 
     * @param user
     * @param resource
     * @return
     * @throws MalformedURLException
     */
    protected String getNoPermissionUrl(String user, String resource) throws MalformedURLException {
        Builder noPermissionUrlBuilder = urlBuilders.get(noPermissionUrl).forPath(null);
        noPermissionUrlBuilder.put("user", user);
        noPermissionUrlBuilder.put("resource", resource);
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
