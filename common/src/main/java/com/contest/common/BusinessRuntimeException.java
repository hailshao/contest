package com.contest.common;

/**
 * @description 异常类
 * @author zhangsan
 * @date 2018年7月30日 下午12:20:01
 * @Copyright 版权所有 (c) www.jiuqi.com
 * @memo 无备注说明
 */
public class BusinessRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -3131398131550932778L;

	public BusinessRuntimeException(String message) {
		super(message);
	}

	public BusinessRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessRuntimeException(Throwable cause) {
		super(cause);
	}
}
