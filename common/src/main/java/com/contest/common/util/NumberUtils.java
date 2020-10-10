package com.contest.common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * <p>数值判断工具类</p>
 *
 * @author zhangsan
 * @version 2019年8月9日
 */
public class NumberUtils {

    /**
     * 最小精度
     */
    public static final double TINY_MIN_DOUBLE_VALUE = 0.0001;

    /**
     * 判断金额是否为0
     *
     * @param value
     * @return 2011-6-10 luyancan
     */
    public static boolean isZreo(Double value) {
        if (value == null) {
            return true;
        }
        return Math.abs(value) <= TINY_MIN_DOUBLE_VALUE;
    }

    /**
     * 科学计数法字符串
     *
     * @param value
     * @param decimal
     * @return
     */
    public static String doubleToString(double value, int decimal) {
        return doubleToString(round(value, decimal), decimal, true);
    }

    /**
     * 科学计数法字符串
     *
     * @param value
     * @return
     */
    public static String doubleToString(double value) {
        return doubleToString(value, 2);
    }

    public static String doubleToString(double value, int decimal, boolean group) {
        DecimalFormat format = new DecimalFormat();
        format.setMaximumFractionDigits(decimal);
        format.setMinimumFractionDigits(decimal);
        format.setGroupingUsed(group);
        return format.format(value);
    }

    /**
     * 对double数据进行取精度.
     *
     * @param value        double数据.
     * @param scale        精度位数(保留的小数位数).
     * @param roundingMode 精度取值方式.
     * @return 精度计算后的数据.
     */
    public static double round(double value, int scale, int roundingMode) {
        BigDecimal bd = createBigDecimal(value);
        bd = bd.setScale(scale, roundingMode);
        return bd.doubleValue();
    }

    /**
     * 根据double值创建BigDecimal
     *
     * @param value
     * @return
     */
    public static BigDecimal createBigDecimal(double value) {
        return BigDecimal.valueOf(value);
    }

    /**
     * 对double数据进行取精度，超出末位部分四舍五入
     *
     * @param value
     * @param scale
     * @return
     */
    public static double round(double value, int scale) {
        return round(value, scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 对double数据进行取精度，保留两位小数，超出部分四舍五入
     *
     * @param value
     * @return
     */
    public static double round(double value) {
        return round(value, 2);
    }

    /**
     * BigDecimal 相加
     *
     * @param bd1
     * @param bd2
     * @return
     */
    public static BigDecimal sum(BigDecimal bd1, BigDecimal bd2) {
        return bd1.add(bd2);
    }

    /**
     * BigDecimal 相减
     *
     * @param bd1
     * @param bd2
     * @return
     */
    public static BigDecimal sub(BigDecimal bd1, BigDecimal bd2) {
        return bd1.subtract(bd2);
    }

    /**
     * double 相加
     *
     * @param d1
     * @param d2
     * @return
     */
    public static double sum(double d1, double d2) {
        return sum(createBigDecimal(d1), createBigDecimal(d2)).doubleValue();
    }

    public static double sum(Double d1, Double d2) {
        return sum(d1 == null ? BigDecimal.ZERO : createBigDecimal(d1),
                d2 == null ? BigDecimal.ZERO : createBigDecimal(d2)).doubleValue();
    }

    /**
     * double 相减
     *
     * @param d1
     * @param d2
     * @return
     */
    public static double sub(double d1, double d2) {
        return sub(createBigDecimal(d1), createBigDecimal(d2)).doubleValue();
    }

    public static double sub(Double d1, Double d2) {
        return sub(d1 == null ? BigDecimal.ZERO : createBigDecimal(d1),
                d2 == null ? BigDecimal.ZERO : createBigDecimal(d2)).doubleValue();
    }

}
