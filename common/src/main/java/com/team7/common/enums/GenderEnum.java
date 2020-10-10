package com.team7.common.enums;

/**
 * @author zhangsan
 */
public enum GenderEnum {

    /**
     * 授权码模式
     */
    MAN("1", "男"),
    /**
     * 密码模式
     */
    WOMEN("2", "女");

    private String code;
    private String title;

    GenderEnum(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public static String getTitleByCode(String code) {
        for (GenderEnum value : values()) {
            if (value.getCode().equals(code)) {
                return value.getTitle();
            }
        }
        return null;
    }
}
