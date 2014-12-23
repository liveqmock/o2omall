package com.hbird.common.web.context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hbird.common.utils.cookie.CookieUtils;

/**
 * 在Cookie中保存登录的用户信息的助手类
 * 
 * @author ljz
 * 
 */
public class LoginUserUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginUserUtils.class);

    private static String userCookieName = "_i_u_cookie_";

    public void setUserCookieName(String userCookieName) {
        if (LoginUserUtils.userCookieName == null) {
            LoginUserUtils.userCookieName = userCookieName;
        }
    }

    public static String getUserCookieName() {
        return LoginUserUtils.userCookieName;
    }

    /**
     * 从HttpServletRequest获取Cookie然后解析为登录用户的对象
     * 
     * @param request
     * @return
     */
    public static LoginUser getCookieValue(HttpServletRequest request) {
        String cookieValue = CookieUtils.getCookieValue(request, userCookieName);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("get cookie, cookieValue = " + cookieValue);
        }
        return LoginUser.parse(cookieValue);
    }

    /**
     * 设置Cookie
     * 
     * @param response
     * @param user
     */
    public static void setCookie(HttpServletResponse response, LoginUser user) {
        if (user != null) {
            String cookieValue = user.toString();
            CookieUtils.setCookie(response, userCookieName, cookieValue);

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("setCookie, cookName={}, value={} ", userCookieName, cookieValue);
            }
        }
    }

    /**
     * 设置Cookie失效
     * 
     * @param response
     * @param user
     */
    public static void invalidateCookie(HttpServletResponse response) {
        CookieUtils.invalidateCookie(response, userCookieName);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("invalidateCookie, cookName={} ", userCookieName);
        }

    }
}
