package com.hbird.common.utils;

import java.security.SecureRandom;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

/**
 * 封装各种生成唯一性ID算法的工具类.
 * 
 * @author lz
 */
public class Identities {

    /** The random. */
    private static SecureRandom random = new SecureRandom();

    /**
     * Instantiates a new identities.
     */
    private Identities() {
    }

    /**
     * 封装JDK自带的UUID, 通过Random数字生成,中间有-分割.
     * 
     * @return the string
     */
    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    /**
     * 封装JDK自带的UUID, 通过Random数字生成,中间无-分割.
     * 
     * @return the string
     */
    public static String uuid2() {
        return uuid().replaceAll("-", "");
    }

    /**
     * 使用SecureRandom随机生成Long.
     * 
     * @return the long
     */
    public static long randomLong() {
        return random.nextLong();
    }

    /**
     * 生成固定长度的编号,默认使用“0”补充
     * 
     * @param prefixStr
     *            编号前缀
     * @param id
     *            序列号-一般是数据库ID
     * @param length
     *            数字部分的长度（不包括前缀）
     * @return 固定长度的编号
     */
    public static String generateCode(String prefixStr, Long id, int length) {
        return Identities.generateCode(prefixStr, id, length, "0");
    }

    /**
     * 生成固定长度的编号
     * 
     * @param prefixStr
     *            编号前缀
     * @param id
     *            序列号-一般是数据库ID
     * @param length
     *            数字部分的长度（不包括前缀）
     * @param placeHoder
     *            数字长度不够时，填充的值
     * @return 固定长度的编号
     * @author gaohongjing
     */
    public static String generateCode(String prefixStr, Long id, int length, String placeHoder) {
        if (null == id) {
            throw new NullPointerException("Param id must be not null");
        }

        if (length <= 0) {
            throw new IllegalArgumentException("Param codeLen must > 0");
        }

        if (StringUtils.isBlank(placeHoder)) {
            throw new IllegalArgumentException("Param placeHoder must be not null");
        }

        // srcStr长度大于设定长度，取全部；若小于设定长度前面补placeHoder的值
        String srcStr = String.valueOf(id);
        StringBuilder code = new StringBuilder(StringUtils.trimToEmpty(prefixStr));
        if (srcStr.length() < length) {
            for (int i = length; i > srcStr.length(); i--) {
                code.append(placeHoder);
            }
        }
        code.append(srcStr);
        return code.toString();
    }
}
