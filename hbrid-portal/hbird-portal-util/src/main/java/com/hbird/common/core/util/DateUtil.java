package com.hbird.common.core.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * 日期工具类 User: ljz DateTime: 2012-7-10 下午02:03:56 Version: 1.0
 */
public class DateUtil {

    public static final String DEFAULE_DATEFORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String YYYYMMDD_DATEFORMAT_PATTERN = "yyyyMMdd";

    /**
     * 日期转换为字符串
     * 
     * @author ljz
     * @param date
     *            待转换日期
     * @param dateFormatPattern
     *            日期转换格式 比如:"yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static String date2String(Date date, String dateFormatPattern) {
        if (StringUtils.isEmpty(dateFormatPattern)) {
            dateFormatPattern = DEFAULE_DATEFORMAT_PATTERN;
        }
        DateFormat df = new SimpleDateFormat(dateFormatPattern);
        return df.format(date);
    }

    /**
     * 日期转换为字符串
     * 
     * @author ljz
     * @param date
     *            待转换日期
     * @return
     */
    public static String date2String(Date date) {
        return date2String(date, DEFAULE_DATEFORMAT_PATTERN);
    }

    /**
     * 获取当前时间字符串 格式：yyyyMMdd
     * 
     * @author ljz
     * @param dateFormatPattern
     *            日期转换格式
     * @return
     */
    public static String getCurrentDateStr(String dateFormatPattern) {
        if (StringUtils.isEmpty(dateFormatPattern)) {
            dateFormatPattern = YYYYMMDD_DATEFORMAT_PATTERN;
        }
        return date2String(new Date(), dateFormatPattern);
    }

    /**
     * 获取当前时间字符串 比如：yyyyMMdd
     * 
     * @author ljz
     * @param dateFormatPattern
     *            日期转换格式
     * @return
     */
    public static String getCurrentDateStr() {
        return getCurrentDateStr(null);
    }

    /**
     * 字符转换为日期（yyyy-MM-dd HH:mm:ss）
     * 
     * @param dateString
     * @return
     */
    public static Date parseDateTime(String dateString) {
        return DateUtil.parseDate(dateString, DEFAULE_DATEFORMAT_PATTERN);
    }

    /**
     * 字符转换为日期
     * 
     * @param dateString
     *            字符串日期
     * @param format
     *            日期格式
     * @return
     */
    public static Date parseDate(String dateString, String format) {
        if (format == null) {
            return null;
        }

        try {
            return new SimpleDateFormat(format).parse(dateString);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取当前时间 milliseconds
     * 
     * @return
     */
    public static long getCurrentTime() {
        return new Date().getTime();
    }

    /**
     * 将毫秒数转换为日期
     * 
     * @param milliseconds
     * @return
     */
    public static Date toDate(long milliseconds) {
        return new Date(milliseconds);
    }

}
