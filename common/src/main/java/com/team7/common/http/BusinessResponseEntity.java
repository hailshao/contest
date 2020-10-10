package com.team7.common.http;


import com.team7.common.util.StringUtils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;

/**
 * @description API响应数据结构实体
 * @author WANGJIHONG
 * @param <T>
 * @date 2018年7月30日 上午10:03:57
 * @Copyright 版权所有 (c) jiuqi.com.cn
 * @memo <b><响应实体数据结构></b>： <br/>
 *       { <br/>
 *       // 响应时间信息 <br/>
 *       "timestamp": "2018-07-24 13:16:50", <br/>
 *       // 接收请求后业务处理是否成功，true标识成功,false失败。 <br/>
 *       "success": false, <br/>
 *       // errorCode表示错误码，前端对错误码做处理，如TOKEN校验失败返回400101码，前端拦截跳转登录页面。 <br/>
 *       "errorCode": "400101", <br/>
 *       // errorMessage表示人类可读的错误消息，国际化信息，如异常message信息。 <br/>
 *       "errorMessage": "处理成功", <br/>
 *       // 响应失败详细信息（表示完整详细信息），如：异常详细堆栈信息<br/>
 *       "errorDetail": "", <br/>
 *       // data表示接收成功后服务端返回的具体业务数据 <br/>
 *       "data": {} <br/>
 *       } <br/>
 *       <br/>
 *       <b><规约></b>： <br/>
 *       1.请求接收成功通过该实体返回的response.status均为200； <br/>
 *       2.请求接收成功但业务处理失败、抛异常，返回的response.data.success为false； <br/>
 *       3.请求接收成功系统需要提供一些错误码来让前端识别做特定处理，则自定义response.data.errorCode来作为标识。<br/>
 *       4.请求接收失败等其他服务异常状态下，默认走的是框架本身的返回状态码, 即response.status不等于200。 <br/>
 *       5.controller层返回的实体统一用该实体VaResponseEntity。 <br/>
 *       <br/>
 *       <b><前端处理流程></b>： <br/>
 *       前端添加axios.interceptors.response.use响应拦截器，然后按下列步骤处理。<br/>
 *       1. 第一步：判断response.status==200是否成立。<br/>
 *       （1）若成立则进入第二步判断。<br/>
 *       （2）若不成立前端直接抛异常发送给this.$http.post('/api/*').catch(response.data)中；<br/>
 *       2.第二步：判断response.data.errorCode等于某些特定错误码，如response.data.errorCode==400101。<br/>
 *       （1）若成立则拦截前端做TOKEN异常的跳转登录界面操作，其他错误码类似；<br/>
 *       （2）若不成立则进入第三步判断。<br/>
 *       3.第三步：判断response.data.success==true是否成立。<br/>
 *       （1）若成立则标识业务处理成功直接将response.data发送给下游then方法中，进入第四步处理。如this.$http.post('/api/*').then(response.data)方法中;<br/>
 *       （2）若不成立则直接抛异常发送下游catch方法中，进入第四步处理。如：this.$http.post('/api/*').catch(response.data)。<br/>
 *       4.第四步：下游处理人员再各自的then和catch中做自己的业务处理即可。<br/>
 */
public final class BusinessResponseEntity<T> {

	/**
	 * 响应反馈日期时间
	 */
	private String timestamp;

	/**
	 * 响应业务处理成功状态（传递API/业务领域中处理是否成功信息。）
	 */
	private boolean success;
	/**
	 * 响应失败错误码
	 */
	private String errorCode;
	/**
	 * 响应失败信息（表示人类可读的错误消息，国际化信息。），如：异常message
	 */
	private String errorMessage;

	/**
	 * 响应失败详细信息（表示完整详细信息），如：异常详细堆栈信息
	 */
	private String errorDetail;

	/**
	 * 响应成功数据（表示成功响应体数据）
	 */
	private T data;

	private BusinessResponseEntity() {
		this.timestamp = LocalDateTime.now().toString();
	}

	/**
	 * 构建业务处理成功信息
	 * 
	 * @return VaResponseEntity 返回响应实体
	 */
	public static <T> BusinessResponseEntity<T> ok() {
		return ok(null);
	}

	public static <T> BusinessResponseEntity<T> ok(T data) {
		return new BusinessResponseEntity<T>().success(true).data(data);
	}
	
	/**
	 * 构建业务处理失败信息
	 * 
	 * @return VaResponseEntity 返回响应实体
	 */
	public static <T> BusinessResponseEntity<T> error() {
		return error(null, null);
	}

	public static <T> BusinessResponseEntity<T> error(String errorMessage) {
		return error(null, errorMessage, null);
	}

	public static <T> BusinessResponseEntity<T> error(String errorCode, String errorMessage) {
		return error(errorCode, errorMessage, null);
	}

	public static <T> BusinessResponseEntity<T> error(String errorCode, String errorMessage, String errorDetail) {
		return new BusinessResponseEntity<T>().success(false).errorCode(errorCode).errorMessage(errorMessage).errorDetail(errorDetail);
	}

	/** 
	 * 依据错误码来构建响应实体
	 */ 
	public static <T> BusinessResponseEntity<T> error(BusinessResponseErrorCodeEnum errorCodeEnum) {
		return error(errorCodeEnum.getErrorCode(), errorCodeEnum.getErrorTitle());
	}
	
	/** 
	 * 依据异常对象来构建响应实体
	 */ 
	public static <T> BusinessResponseEntity<T> error(Throwable e) {
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter, true);
		e.printStackTrace(printWriter);
		printWriter.flush();
		stringWriter.flush();
		String errorDetail = stringWriter.toString();
		String errorMessage = StringUtils.isEmpty(e.getMessage()) ? "系统处理过程中发生异常错误。" : e.getMessage();
		return error(null, errorMessage, errorDetail);
	}
	
	/**
	 * 构建业务是否处理成功信息
	 * 
	 * @return VaResponseEntity 返回响应实体
	 */ 
	public BusinessResponseEntity<T> success(boolean isSuccess) {
		this.success = isSuccess;
		return this;
	}
	
	/**
	 * 构建响应失败代码
	 * 
	 * @param errorCode
	 *            错误码
	 * @return VaResponseEntity 返回响应实体
	 */
	public BusinessResponseEntity<T> errorCode(String errorCode) {
		this.errorCode = errorCode;
		return this;
	}

	/**
	 * 构建可读的错误消息
	 * 
	 * @param errorMessage
	 *            可读的错误消息
	 * @return VaResponseEntity 返回响应实体
	 */
	public BusinessResponseEntity<T> errorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}

	/**
	 * 构建完整失败详细信息
	 * 
	 * @param errorDetail
	 *            完整失败详细信息
	 * @return VaResponseEntity 返回响应实体
	 */
	public BusinessResponseEntity<T> errorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
		return this;
	}

	/**
	 * 构建响应成功的响应体数据
	 * 
	 * @param data
	 *            成功的响应体数据
	 * @return VaResponseEntity 返回响应实体
	 */
	public BusinessResponseEntity<T> data(T data) {
		this.data = data;
		return this;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public boolean isSuccess() {
		return success;
	}

	public T getData() {
		return data;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getErrorDetail() {
		return errorDetail;
	}

	public String getErrorCode() {
		return errorCode;
	}

}