package com.hbird.common.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.ObjectUtils;

import com.hbird.common.utils.StringUtil;

/**
 * Number助手类
 * 
 * @author lz
 * @version 2014-8-8 16:19:30
 */
public class NumberHelper {

    /**
     * 字符串转换为Long数组
     * 
     * @param ids
     *            字符串
     * @param delimiter
     *            分隔符
     * @return
     */
    public static Long[] parseToLong(String ids, String delimiter) {
        String[] array = StringUtils.split(ids, delimiter);
        if (ObjectUtils.isEmpty(array)) {
            return null;
        }
        Long[] longIds = new Long[array.length];
        for (int i = 0; i < array.length; i++) {
            longIds[i] = Long.valueOf(array[i]);
        }
        return longIds;
    }

    /**
     * 字符串转换为Long数组,默认使用逗号分隔
     * 
     * @param ids
     *            字符串
     * @return
     */
    public static Long[] parseToLong(String ids) {
        return NumberHelper.parseToLong(ids, StringUtil.SEP_COMMA);
    }

    /**
     * 字符串转换为Integer数组
     * 
     * @param ids
     *            字符串
     * @param delimiter
     *            分隔符
     * @return
     */
    public static Integer[] parseToInteger(String ids, String delimiter) {
        String[] array = StringUtils.split(ids, delimiter);
        if (ObjectUtils.isEmpty(array)) {
            return null;
        }
        Integer[] longIds = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            longIds[i] = Integer.valueOf(array[i]);
        }
        return longIds;
    }

    /**
     * 字符串转换为Integer数组,默认使用逗号分隔
     * 
     * @param ids
     *            字符串
     * @return
     */
    public static Integer[] parseToInteger(String ids) {
        return NumberHelper.parseToInteger(ids, StringUtil.SEP_COMMA);
    }

}
