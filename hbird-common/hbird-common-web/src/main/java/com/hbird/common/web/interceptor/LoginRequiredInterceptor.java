package com.hbird.common.web.interceptor;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.web.context.ExcludeRequstPath;
import com.hbird.common.web.context.UserContext;
import com.hbird.common.web.url.UrlBuilder.Builder;
import com.hbird.common.web.url.UrlBuilders;

/**
 * 登录用户验证的拦截器<br/>
 * 主要作用：<br/>
 * 拦截用户请求， 判断UserContext中是否有登录用户信息；<br/>
 * 如果没有则跳转到登录界面。
 * 
 * @see com.hbird.common.web.context.UserContext
 * 
 * @author lz
 * 
 */
public class LoginRequiredInterceptor extends AbstractHandlerInterceptorAdapter {

    protected UrlBuilders urlBuilders;
    protected String homeModule = "homeModule";
    protected String loginUrl = "loginUrl";

    private final static Log LOG = LogFactory.getLog(LoginRequiredInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws IOException, MalformedURLException {
        String uri = request.getRequestURI();
        if (ExcludeRequstPath.isExclude(getExcludePaths(), uri)) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("in request [" + uri + "], this url is excludeRequstPath");
            }
            return true;
        }
        try {
            // check 有没有登录
            UserContext context = UserContext.get();
            if (context == null || !context.isLogin()) {// 没登录
                response.sendRedirect(getLoginUrl(request));
                return false;
            }
        } catch (Throwable t) {
            LOG.warn("getUserContext error!", t);
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    protected String getLoginUrl(HttpServletRequest request) throws MalformedURLException {
        Builder currentUrlBuilder = urlBuilders.get(homeModule).forPath(request.getRequestURI());
        currentUrlBuilder.put(request.getParameterMap());

        Builder loginUrlBuilder = urlBuilders.get(loginUrl).forPath(null);

        loginUrlBuilder.put("ReturnUrl", currentUrlBuilder.build());

        return loginUrlBuilder.build();
    }

    public void setUrlBuilders(UrlBuilders urlBuilders) {
        this.urlBuilders = urlBuilders;
    }

    public void setHomeModule(String homeModule) {
        this.homeModule = homeModule;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }
}
