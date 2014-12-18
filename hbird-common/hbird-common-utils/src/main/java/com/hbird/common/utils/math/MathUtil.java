package com.hbird.common.utils.math;

import java.math.BigDecimal;

/**
 * 数学相关的算法：支持double的加减乘除
 * 
 * @author zhc
 * @email zhc@hbird.com
 * @version 2014-7-15 下午03:38:56
 */
public class MathUtil {

    /**
     * 高精度加法计算
     * 
     * @param num1
     * @param num2
     * @param point
     *            有效小数位数
     * @return
     */
    public static double add(double num1, double num2, int point) {
        BigDecimal bd1 = new BigDecimal(Double.toString(num1));
        BigDecimal bd2 = new BigDecimal(Double.toString(num2));
        return bd1.add(bd2).setScale(point, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 
     * 高精度减法计算
     * 
     * @param num1
     * @param num2
     * @param point
     *            有效小数位数
     * @return
     */
    public static double subtrace(double num1, double num2, int point) {
        BigDecimal bd1 = new BigDecimal(Double.toString(num1));
        BigDecimal bd2 = new BigDecimal(Double.toString(num2));
        return bd1.subtract(bd2).setScale(point, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 高精度乘法计算
     * 
     * @param num1
     * @param num2
     * @param point
     *            有效小数位数
     * @return
     */
    public static double mul(double num1, double num2, int point) {
        BigDecimal bd1 = new BigDecimal(Double.toString(num1));
        BigDecimal bd2 = new BigDecimal(Double.toString(num2));
        return bd1.multiply(bd2).setScale(point, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 高精度乘法计算
     * 
     * @param num1
     * @param num2
     * @param point
     *            有效小数位数
     * @return
     */
    public static double mul(double num1, int num2, int point) {
        BigDecimal bd1 = new BigDecimal(Double.toString(num1));
        BigDecimal bd2 = new BigDecimal(Integer.toString(num2));
        return bd1.multiply(bd2).setScale(point, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 高精度除法计算
     * 
     * @param num1
     * @param num2
     * @param scale
     *            有效小数位数
     * @return
     */
    public static double divide(double num1, double num2, int scale) {
        BigDecimal bd1 = new BigDecimal(Double.toString(num1));
        BigDecimal bd2 = new BigDecimal(Double.toString(num2));
        return bd1.divide(bd2, scale, BigDecimal.ROUND_HALF_EVEN).doubleValue();
    }
}
