package com.hbird.common.utils.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.utils.encode.Encodes;

/**
 * 签名认证工具类
 * 
 * @author ljz
 * @version 2014-12-18 下午4:28:25
 */
public class SignatureUtil {
    /**
     * 默认的字符编码
     */
    private static final String DEFAULT_CHARSET_NAME = "UTF-8";
    private static final Log LOG = LogFactory.getLog(SignatureUtil.class);

    /**
     * 生成签名
     * 
     * @param content
     *            加密前的内容
     * 
     * @param key
     *            秘钥
     * @return
     */
    public static String generateSign(String content, String key) {
        return SignatureUtil.generate(getEncrypt(content, key));
    }

    /**
     * 校验签名
     * 
     * @param content
     *            加密前的内容
     * @param key
     *            秘钥
     * @param sign
     *            传入签名
     * @return 通过true；不通过false
     */
    public static boolean checkSign(String content, String key, String sign) {
        String signNew = generateSign(content, key);
        return null != signNew && signNew.equals(sign);
    }

    /**
     * 生成签名
     * 
     * @param data
     *            加密之前的数据
     * @return 签名
     */
    private static String generate(String data) {
        try {
            // 1.MD5加密后转16进制
            String sign = MD5Util.md5Hex(data.getBytes(DEFAULT_CHARSET_NAME));
            // 2.BASE64编码
            return Encodes.encodeBase64(sign.getBytes(DEFAULT_CHARSET_NAME));
        } catch (Exception e) {
            if (LOG.isErrorEnabled()) {
                LOG.error("generateSign has error,", e);
            }
        }

        return null;
    }

    /**
     * 得到加密字符串
     * 
     * @param content
     *            加密前的内容
     * @param key
     *            秘钥
     * @return
     */
    private static String getEncrypt(String content, String key) {
        return content + key;
    }

    public static void main(String[] args) {
        System.out.println(generateSign("234567890", "pms"));
        System.out.println(checkSign("234567890", "pms", "ZmE1YmQ3OTRlNTkxMDgxNWExYjM0NDhmYjU5M2QyZGQ="));
    }

}
