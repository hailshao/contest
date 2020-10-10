package com.contest.common.util;

import java.util.Collection;
import java.util.Map;

/**
 * 断言工具，提供静态方法进行断言判断，用以帮助在调试阶段验证程序正确性。<br>
 * 用于断言判断的语句在正式运行期应该不可能出现不满足的异常，否则应该检查程序。<br>
 * <br>
 * 例如，isNotNull断言用于确认参数不可能为空，或者确认在执行完一段代码后某个对象<br>
 * 不可能为空，如果出现断言不满足的异常，说明程序有不够严谨的地方，需要进行完善。<br>
 * 但如果参数可能为空，或者某个对象可允许不被创建，则不应使用isNotNull断言。<br>
 * 
 * @author zhangsan
 * 
 */
public class Assert {

	/**
	 * 断言表达式结果应为true
	 */
	public static void isTrue(boolean expression) {
		isTrue(expression, "断言失败：表达式结果应为true。");
	}

	/**
	 * 断言表达式结果应为true，可指定错误消息
	 */
	public static void isTrue(boolean expression, String message, Object... args) {
		if (!expression){
			throwException(message, args);
		}
	}

	/**
	 * 断言表达式结果应为false
	 */
	public static void isFalse(boolean expression) {
		isTrue(!expression, "断言失败：表达式结果应为false。");
	}

	/**
	 * 断言表达式结果应为false，可指定错误消息
	 */
	public static void isFalse(boolean expression, String message, Object... args) {
		isTrue(!expression, message, args);
	}

	/**
	 * 断言对象应为null
	 */
	public static void isNull(Object object) {
		isNull(object, "断言失败：对象应为null。");
	}

	/**
	 * 断言对象应为null，可指定错误消息
	 */
	public static void isNull(Object object, String message, Object... args) {
		if (object != null){
			throwException(message, args);
		}
	}

	/**
	 * 断言对象不应为null
	 */
	public static void isNotNull(Object object) {
		isNotNull(object, "断言失败：对象不应为null。");
	}

	/**
	 * 断言对象不应为null，可指定错误消息
	 */
	public static void isNotNull(Object object, String message, Object... args) {
		if (object == null){
			throwException(message, args);
		}
	}

	/**
	 * 断言集合不应为空
	 */
	public static void isNotEmpty(Collection<?> collection) {
		isNotEmpty(collection, "断言失败：集合中至少应包含一个数据项。");
	}

	/**
	 * 断言集合不应为空，可指定错误消息
	 */
	public static void isNotEmpty(Collection<?> collection, String message, Object... args) {
		if (collection == null || collection.isEmpty()){
			throwException(message, args);
		}
	}

	/**
	 * 断言数组不应为空
	 */
	public static <T> void isNotEmpty(T[] array) {
		isNotEmpty(array, "断言失败：数组中至少应包含一个数据项。");
	}

	/**
	 * 断言数组不应为空，可指定错误消息
	 */
	public static <T> void isNotEmpty(T[] array, String message, Object... args) {
		if (array == null || array.length == 0){
			throwException(message, args);
		}
	}

	/**
	 * 断言Map不应为空
	 */
	public static void isNotEmpty(Map<?, ?> map) {
		isNotEmpty(map, "断言失败：Map中至少应包含一个数据项。");
	}

	/**
	 * 断言Map不应为空，可指定错误消息
	 */
	public static void isNotEmpty(Map<?, ?> map, String message, Object... args) {
		if (map == null || map.isEmpty()){
			throwException(message, args);
		}
	}

	/**
	 * 断言字符串不应为空
	 * @param str
	 */
	public static void isNotEmpty(String str) {
		isFalse(StringUtils.isEmpty(str), "断言失败：字符串不应为空。");
	}
	
	/**
	 * 断言字符串不应为空，可指定错误消息
	 * @param str
	 * @param message
	 * @param args
	 */
	public static void isNotEmpty(String str, String message, Object... args) {
		isFalse(StringUtils.isEmpty(str), message, args);
	}
	
	/**
	 * 断言数字应为0
	 * 
	 * @param number
	 */
	public static void isZero(Number number) {
		isNotZero(number, "断言失败：数字不应为0。");
	}
	
	/**
	 * 断言数字应为0，可指定错误消息
	 * 
	 * @param number
	 * @param message
	 * @param args
	 */
	public static void isZero(Number number, String message, Object... args) {
		isNotNull(number, message, args);
		isTrue(number.doubleValue() == 0.0f, message, args);
	}

	/**
	 * 断言数字不应为0
	 * 
	 * @param number
	 */
	public static void isNotZero(Number number) {
		isNotZero(number, "断言失败：数字不应为0。");
	}
	
	/**
	 * 断言数字不应为0，可指定错误消息
	 * 
	 * @param number
	 * @param message
	 * @param args
	 */
	public static void isNotZero(Number number, String message, Object... args) {
		isNotNull(number, message, args);
		isFalse(number.doubleValue() == 0.0f, message, args);
	}

	/**
	 * 断言对象为指定类型
	 */
	public static void isInstanceOf(Class<?> clazz, Object obj) {
		isNotNull(clazz, "断言失败：指定类型不应为空。");
		isNotNull(obj);
		if (!clazz.isInstance(obj)){
			throwException("断言失败：对象类型应为%s。", clazz.getName());
		}
	}

	/**
	 * 断言对象为指定类型，可指定错误消息
	 * @param clazz
	 * @param obj
	 * @param message
	 * @param args
	 */
	public static void isInstanceOf(Class<?> clazz, Object obj, String message, Object... args) {
		isNotNull(clazz, message, args);
		isNotNull(obj, message, args);
		if (!clazz.isInstance(obj)){
			throwException(message, args);
		}
	}
	
	private static void throwException(String message, Object... args) {
		throw new IllegalArgumentException((args == null || args.length == 0 ? 
				message : String.format(message, args)));
	}

}
