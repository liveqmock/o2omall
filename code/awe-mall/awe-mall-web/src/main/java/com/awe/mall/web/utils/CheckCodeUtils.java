package com.awe.mall.web.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.hbird.common.utils.DateHelper;
import com.hbird.common.utils.cookie.CookieUtils;
import com.hbird.common.utils.encode.Encodes;
import com.hbird.common.utils.security.MD5Util;

/**
 * 验证码的助手类
 * 
 * @author ljz
 * @version 2014-12-27 下午6:52:21
 */
public class CheckCodeUtils {

    /** 图片校验码 COOKIE */
    private static final String COOKIE_NAME_CHECK_CODE = "_m_c_c_cookie_";
    /** 手机校验码 COOKIE */
    private static final String COOKIE_NAME_SMS_CODE = "_m_s_c_cookie_";
    
    private static final String COOKIE_DOMAIM = "shop.hbird.com";
    private static final String COOKIE_PATH = "/";
    /** 校验码加密的私钥 */
    private static final String PRIVATE_KEY = "HBIRD" + DateHelper.today();

    private CheckCodeUtils() {
    } 

    /**
     * 将生成的图片验证码加密后保存到Cookie中
     * 
     * @param response
     * @param checkCode 
     */
    public static void storeCheckCode(HttpServletResponse response, String checkCode){ 
        String cookieValue = encryptCheckCode(checkCode);
        setCookie(response, COOKIE_NAME_CHECK_CODE, cookieValue, COOKIE_DOMAIM, COOKIE_PATH);
    }

    /**
     * 将生成的手机验证码加密后保存到Cookie中
     * 
     * @param response
     * @param checkCode 
     */
    public static void storeSmsCode(HttpServletResponse response, String checkCode){ 
        String cookieValue = encryptCheckCode(checkCode);
        setCookie(response, COOKIE_NAME_SMS_CODE, cookieValue, COOKIE_DOMAIM, COOKIE_PATH);
    }
    
    /**
     * 写入Cookie
     * 
     * @param response
     * @param name
     * @param value
     * @param domain
     * @param path
     */
    static void setCookie(HttpServletResponse response, String name, String value, String domain, String path) {
        Cookie cookie = new Cookie(name, Encodes.encodeBase64(value.getBytes()));
        cookie.setDomain(domain);
        cookie.setPath(path);
        response.addCookie(cookie);
    }
    /**
     * 验证码加密 ：md5(私钥+验证码转大写字母)
     * 
     * @param code
     * @return
     */
    static String encryptCheckCode(String code) {
        return MD5Util.md5Hex(PRIVATE_KEY + StringUtils.trimToEmpty(code).toUpperCase());
    }

    /**
     * 校验用户输入的随机图片验证码
     * 
     * @param checkCode
     * @param request
     * @return
     */
    public static boolean validateCheckCode(String checkCode, HttpServletRequest request) {
        String cookieValue = CookieUtils.getCookieValue(request, COOKIE_NAME_CHECK_CODE);
        return StringUtils.isNotBlank(cookieValue) && cookieValue.equals(encryptCheckCode(checkCode));
    }

    /**
     * 校验用户输入的随机短信验证码
     * 
     * @param checkCode
     * @param request
     * @return
     */
    public static boolean validateSmsCode(String checkCode, HttpServletRequest request) {
        String cookieValue = CookieUtils.getCookieValue(request, COOKIE_NAME_SMS_CODE);
        return StringUtils.isNotBlank(cookieValue) && cookieValue.equals(encryptCheckCode(checkCode));
    }

}
