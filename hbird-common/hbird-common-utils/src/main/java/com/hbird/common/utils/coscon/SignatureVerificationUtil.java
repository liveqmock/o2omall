package com.hbird.common.utils.coscon;

import java.io.UnsupportedEncodingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.misc.BASE64Encoder;

/**
 * 中远签名认证工具类
 * 
 * @author liudonghai
 * @date 2014-08-15
 */
@SuppressWarnings("restriction")
public class SignatureVerificationUtil {
    private static Log log = LogFactory.getLog(SignatureVerificationUtil.class);

    /**
     * 加密处理
     * 
     * @param plainText
     * @return
     */
    public static String crypt(byte bytes[]) {
        StringBuffer buf = new StringBuffer();
        for (int offset = 0; offset < bytes.length; offset++) {
            int i = bytes[offset];
            if (i < 0) {
                i += 256;
            }
            if (i < 16) {
                buf.append("0");
            }
            buf.append(Integer.toHexString(i));
        }
        return buf.toString();
    }

    /**
     * 生成签名
     * 
     * @param data
     *            报文
     * @param encoding
     *            编码
     * @return 签名
     */
    public static String generateSign(String data, String encoding) {
        // 1.MD5编码
        String sign = null;

        try {
            byte[] bytes = md5(data.getBytes(encoding));

            // 2.加密处理
            sign = crypt(bytes);

            // 3.BASE64编码
            BASE64Encoder encoder = (new sun.misc.BASE64Encoder());
            sign = encoder.encode(sign.getBytes(encoding));
            log.debug("generateSign hbirdedi encoding = " + encoding);
        } catch (UnsupportedEncodingException e) {
            log.error(e);
        } catch (Exception e) {
            log.error(e);
        }

        return sign;
    }

    /**
     * MD5加密
     * 
     * @param input
     *            报文
     * @return 加密文
     * @throws Exception
     */
    public static byte[] md5(byte[] input) throws Exception {
        java.security.MessageDigest alg = java.security.MessageDigest.getInstance("MD5");
        alg.update(input);
        byte[] digest = alg.digest();
        return digest;
    }

    /**
     * 签名校验
     * 
     * @param content
     *            报文体
     * @param key
     *            秘钥
     * @param sign
     *            传入签名
     * @return 通过true；不通过false
     */
    public static boolean check(String content, String key, String sign) {
        return check(content + key, sign);
    }

    /**
     * 签名校验
     * 
     * @param encrypt
     *            加密前的字符串
     * @param sign
     *            传入签名
     * @return 通过true；不通过false
     */
    public static boolean check(String encrypt, String sign) {
        String sign_new = generateSign(encrypt, "UTF-8");
        if (sign_new != null && sign_new.equals(sign)) {
            return true;
        }
        log.info("签名验证不通过！生成签名为：" + sign_new + ", 传入签名为：" + sign);
        return false;
    }

}
