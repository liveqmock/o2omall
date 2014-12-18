package com.hbird.common.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.web.context.ExcludeRequstPath;
import com.hbird.common.web.context.LoginUser;
import com.hbird.common.web.context.LoginUserUtils;
import com.hbird.common.web.context.UserContext;

/**
 * 登录用户上下文的拦截器<br/>
 * 主要作用：<br/>
 * 拦截用户请求，获取并解析登录的用户cookie；<br/>
 * 如果有用户信息则存到UserContext。
 * 
 * @see com.hbird.common.web.context.LoginUser
 * @see com.hbird.common.web.context.UserContext
 * 
 * @author ljz
 * 
 */
public class LoginCookieInterceptor extends AbstractHandlerInterceptorAdapter {

    private final static Log LOG = LogFactory.getLog(LoginCookieInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        if (ExcludeRequstPath.isExclude(getExcludePaths(), uri)) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("in request [" + uri + "], this url is excludeRequstPath");
            }
            return true;
        }

        try {
            updateLogin(request, response);
        } catch (Throwable t) {
            LOG.warn("updatelogin error!", t);
        }

        return true;
    }

    private void updateLogin(HttpServletRequest request, HttpServletResponse response) {
        try {
            LoginUser user = LoginUserUtils.getCookieValue(request);
            if (null != user) {
                UserContext.set(user);
                LoginUserUtils.setCookie(response, user);

                if (LOG.isDebugEnabled()) {
                    LOG.debug("getCookieValue has user value");
                }
            } else {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("getCookieValue has no user value");
                }
            }
        } catch (Exception e) {
            LOG.error("getCookieValue has error", e);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        UserContext.remove();
    }

}
