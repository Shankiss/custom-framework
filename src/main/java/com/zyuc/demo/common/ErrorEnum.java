package com.zyuc.demo.common;

/**
 * @Version 1.0
 * @Description 自定义异常枚举
 * @Date 2020/5/8 13:36
 * @Created by ChenHao
 */
public enum ErrorEnum {

    UNKNOWN_ERROR(-1, "未知错误"),
    NULL_PARAMS(101, "参数为空"),
    ;

    ErrorEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
