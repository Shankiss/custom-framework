package com.zyuc.demo.enums;

/**
 * @Version 1.0
 * @Description 自定义状态枚举
 * @Date 2020/7/2 15:16
 * @Created by ChenHao
 */
public enum StateEnum {
    SUCCESS(200,"成功");
    ;

    StateEnum(Integer code, String msg) {
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
