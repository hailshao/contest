package com.team7.common.util;

import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * 字符串辅助函数
 * 
 * @author zhangsan
 *
 */
public class StringUtils {
	/**
	 * 格式化为页面显示字符串
	 * @param value
	 * @return
	 */
	public static String toViewString(Object value) {
		if (value == null) {
			return "";
		} else {
			return String.valueOf(value);
		}
	}

	/**
	 * 判断str是否与列表中任一字符串相同（大小写相关）
	 * 
	 * @param str
	 * @param matchStrs
	 * @return
	 */
	public static boolean equalsAny(String str, String... matchStrs) {
		if (str != null) {
			for (String matchStr : matchStrs) {
				if (str.equals(matchStr)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 判断str是否与列表中任一字符串相同（大小写无关）
	 * 
	 * @param str
	 * @param matchStrs
	 * @return
	 */
	public static boolean equalsIgnoreCaseAny(String str, String... matchStrs) {
		if (str != null) {
			for (String matchStr : matchStrs) {
				if (str.equalsIgnoreCase(matchStr)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 将常见的表示布尔值的字符串转为布尔类型
	 * 
	 * @param str
	 * @return
	 */
	public static boolean convertToBoolean(String str) {
		return equalsIgnoreCaseAny(str, "是", "Y", "Yes", "T", "True") || convertToInteger(str, 0) != 0;
	}

	/**
	 * 判断是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}
	
	/**
	 * 判断是否为空(包含不限大小写null字符串)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str) {
		return isEmpty(str) || "null".equalsIgnoreCase(str);
	}

	/**
	 * 如果参数为空，则返回null，否则返回原参数
	 * 
	 * @param str
	 * @return
	 */
	public static String parseEmpty(String str) {
		return parseEmpty(str, null);
	}

	/**
	 * 如果参数为空，则返回def，否则返回原参数
	 * 
	 * @param str
	 * @return
	 */
	public static String parseEmpty(String str, String def) {
		return isEmpty(str) ? def : str;
	}

	/**
	 * 转换为整型值
	 * 
	 * @param str
	 * @param def
	 *            转换失败的默认值
	 * @return
	 */
	public static int convertToInteger(String str, int def) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return def;
		}
	}

	/**
	 * 转换为浮点值
	 * 
	 * @param str
	 * @param def
	 *            转换失败的默认值
	 * @return
	 */
	public static Double convertToDouble(String str, Double def) {
		try {
			NumberFormat nf = NumberFormat.getInstance(Locale.SIMPLIFIED_CHINESE);
			if (nf instanceof DecimalFormat) {
				((DecimalFormat) nf).setDecimalSeparatorAlwaysShown(true);
			}
			return nf.parse(str).doubleValue();
		} catch (Exception e) {
			return def;
		}
	}

	/**
	 * 对字符串进行URL编码，若编码失败返回原串
	 * 
	 * @param s
	 * @return
	 */
	public static String urlEncode(String s) {
		try {
			return URLEncoder.encode(s, "UTF-8");
		} catch (Exception e) {
			return s;
		}
	}

	/**
	 * 按照给定的字符对字符串进行分隔
	 * 
	 * @param source
	 * @param splitChar
	 * @return
	 */
	public static List<String> split(String source, String splitChar) {
		List<String> list = new ArrayList<>();
		int index = source.indexOf(splitChar);
		while (index != -1) {
			String sub = source.substring(0, index);
			list.add(sub);
			source = source.substring(index + 1, source.length());
			index = source.indexOf(splitChar);
		}
		list.add(source);
		return list;
	}

	/**
	 * Joins the elements of the provided array into a single string containing the
	 * provided list of elements. No delimiter is added before or after the list. A
	 * null separator is the same as a blank String.
	 *
	 * @param array
	 *            the array of values to join together
	 * @param separator
	 *            the separator character to use
	 * @return the joined String
	 */
	public static String join(Object[] array, String separator) {
		if (separator == null) {
			separator = "";
		}
		int arraySize = array.length;
		int bufSize = (arraySize == 0 ? 0 : (array[0].toString().length() + separator.length()) * arraySize);
		StringBuffer buf = new StringBuffer(bufSize);

		for (int i = 0; i < arraySize; i++) {
			if (i > 0) {
				buf.append(separator);
			}
			buf.append(array[i]);
		}
		return buf.toString();
	}
}
