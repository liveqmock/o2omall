package com.hbird.common.utils.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.utils.encode.Encodes;

/**
 * Cookie助手类，提供cookie的读取和写入
 * 
 * @see javax.servlet.http.Cookie
 * @author ljz
 * 
 */
public class CookieUtils {

    private final static Log logger = LogFactory.getLog(CookieUtils.class);
    private final static String COOKIE_DOMAIM = "hbird.com";

    /**
     * 读取Cookie的值:直接返回cookie的值，不编码
     * 
     * @param request
     * @param name
     * @return
     */
    public static String getCookieValueSimple(HttpServletRequest request, String name) {
        String value = null;
        Cookie cookie = CookieUtils.getCookieInfo(request, name);
        if (cookie != null) {
            value = cookie.getValue();
            logger.debug("Found '' cookie value [" + value + "]");
        } else {
            logger.trace("No '{" + name + "}' cookie value");
        }
        return value;
    }

    /**
     * 读取Cookie的值，返回使用Base64解码后的值
     * 
     * @param request
     * @param name
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String name) {
        String sourceValue = CookieUtils.getCookieValueSimple(request, name);
        String value = null;
        if (sourceValue != null) {
            value = new String(Encodes.decodeBase64(sourceValue));
            logger.debug("Found '' cookie value [" + value + "]");
        } else {
            logger.trace("No '{" + name + "}' cookie value");
        }
        return value;
    }

    private static Cookie getCookieInfo(HttpServletRequest request, String cookieName) {
        Cookie cookies[] = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie;
                }
            }
        }
        return null;
    }

    /**
     * 写入Cookie
     * 
     * @param response
     * @param cookieName
     * @param cookieValue
     */
    public static void setCookie(HttpServletResponse response, String cookieName, String cookieValue) {
        Cookie cookie = new Cookie(cookieName, Encodes.encodeBase64(cookieValue.getBytes()));
        cookie.setDomain(COOKIE_DOMAIM);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 设置cookie失效
     * 
     * @param response
     * @param cookieName
     * @param cookieValue
     */
    public static void invalidateCookie(HttpServletResponse response, String cookieName) {
        Cookie cookie = new Cookie(cookieName, "");
        cookie.setDomain(COOKIE_DOMAIM);
        cookie.setPath("/");
        cookie.setMaxAge(0); // 使cookie失效
        response.addCookie(cookie);
    }

}
