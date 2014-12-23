package com.hbird.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期助手类，实现：日期加减计算、日期与字符串互相转换。
 * 
 * @author ljz
 * 
 */
public class DateHelper {

    public static final long TEN_MINUTES = 10 * 60 * 1000;
    public static final long ONE_DAY = 24 * 60 * 60 * 1000;

    /** 日期格式：yyyy-MM-dd */
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    /** 日期格式：yyyyMMdd */
    public static final String DATE_FORMAT_NO_SPLIT = "yyyyMMdd";
    /** 日期格式：yyyy-MM-dd HH:mm:ss */
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /** 日期格式：yyyy-MM-dd HH:mm:ss.SSS */
    public static final String DATE_TIME_MS_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * Adds or subtracts the specified amount of time to the given calendar field, based on the calendar's rules. For
     * example, to subtract 5 days from the current time of the calendar, you can achieve it by calling:
     * <p>
     * <code>add(Calendar.DAY_OF_MONTH, -5)</code>.
     * 
     * @param date
     *            the date of before the changed.
     * @param field
     *            the calendar field.
     * @param amount
     *            the amount of date or time to be added to the field.
     * @return
     */
    public static Date add(final Date date, Integer field, Integer amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(field, amount);

        return calendar.getTime();
    }

    /**
     * add days
     * 
     * @param date
     *            the date of before the changed.
     * @param days
     *            the amount of date to be added to the field Calendar.DATE .
     * @return
     */
    public static Date addDate(final Date date, Integer days) {
        return DateHelper.add(date, Calendar.DATE, days);
    }

    /** 按指定的格式，将日期转换成为字符 */
    public static String format(Date date, String format) {
        if (date == null) {
            return "";
        }

        if (isEmpty(format)) {
            format = DATE_FORMAT;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * @param format
     * @return
     */
    private static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    /** 将日期转换成为字符（yyyy-MM-dd） */
    public static String formatDate(Date date) {
        return format(date, DATE_FORMAT);
    }

    /** 今天日期的字符（yyyy-MM-dd） */
    public static String today() {
        return formatDate(new Date());
    }

    /** 将日期转换成为字符（yyyy-MM-dd HH:mm:ss） */
    public static String formatDateTime(Date date) {
        return format(date, DATE_TIME_FORMAT);
    }

    /**
     * 将日期转换成为字符（yyyy-MM-dd HH:mm:ss.SSS）
     * 
     * @param date
     * @return
     */
    public static String formatDateTimeMs(Date date) {
        return format(date, DATE_TIME_MS_FORMAT);
    }

    public static Date getDateValue(Object object) {
        return null == object ? null : (Date) object;
    }

    /** 按指定的格式，将字符转换为日期 */
    public static Date parseDate(String dateString, String format) {
        if (isEmpty(format)) {
            return null;
        }

        try {
            return new SimpleDateFormat(format).parse(dateString);
        } catch (Exception e) {
            return null;
        }
    }

    /** 将字符（yyyy-MM-dd）转换为日期 */
    public static Date parseDate(String dateString) {
        return DateHelper.parseDate(dateString, DATE_FORMAT);
    }

    /** 将字符（yyyy-MM-dd HH:mm:ss）转换为日期 */
    public static Date parseDateTime(String dateString) {
        return DateHelper.parseDate(dateString, DATE_TIME_FORMAT);
    }

    /**
     * milliseconds 转化为日期
     * 
     * @param date
     * @return
     */
    public static Date toDate(Long date) {
        if (date == null) {
            return null;
        }
        return new Date(date);
    }

    /**
     * 获取当前时间字符串 默认格式：yyyy-MM-dd HH:mm:ss
     * 
     * @param dateFormatPattern
     *            日期转换格式
     * @return
     */
    public static String getCurrentDateStr(String dateFormatPattern) {
        if (isEmpty(dateFormatPattern)) {
            dateFormatPattern = DATE_TIME_FORMAT;
        }
        return format(new Date(), dateFormatPattern);
    }

    public static Date getServerTime(String operateTimeStr) {
        Date serverTime = new Date();
        if (isEmpty(operateTimeStr)) {
            return serverTime;
        }

        Date operateTime = parseDate(operateTimeStr, DATE_TIME_FORMAT);

        if (operateTime == null) {
            operateTime = DateHelper.parseDate(operateTimeStr, DATE_TIME_MS_FORMAT);
        }

        Long interval = operateTime.getTime() - serverTime.getTime();
        if (operateTime.after(serverTime) && TEN_MINUTES < interval) {
            return serverTime;
        } else if (operateTime.before(serverTime) && ONE_DAY < Math.abs(interval)) {
            return serverTime;
        } else {
            return operateTime;
        }
    }

}
