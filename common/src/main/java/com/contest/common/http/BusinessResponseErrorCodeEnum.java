package com.contest.common.http;

/**
 * @author zhangsan
 * @description 系统业务响应错误码枚举（主要为前端做需要特殊处理的系统业务错误码，如token失效错误，前端鉴别该错误码后做跳转登陆页处理。）
 */
public enum BusinessResponseErrorCodeEnum {
    /**
     * 无效的访问令牌
     */
    TOKEN_INVALID("5010001", "无效的访问令牌。");

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误描述
     */
    private String errorTitle;

    /**
     * 不允许外部创建该响应状态码枚举对象，需要添加错误状态码，请在该类中添加枚举，避免前端对于新加的响应状态码遗漏处理的风险
     */
    private BusinessResponseErrorCodeEnum(String errorCode, String errorTitle) {
        this.errorCode = errorCode;
        this.errorTitle = errorTitle;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorTitle() {
        return errorTitle;
    }

}
