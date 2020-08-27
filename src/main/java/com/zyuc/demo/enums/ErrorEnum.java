package com.zyuc.demo.enums;

/**
 * @Version 1.0
 * @Description 自定义异常枚举
 * @Date 2020/7/2 15:14
 * @Created by ChenHao
 */
public enum ErrorEnum {
    INTERNAL_SERVER_ERROR(500, "系统内部错误"),
    INSERT_ERROR(101,"插入数据错误"),
    UPDATE_ERROR(102,"更新数据错误"),
    QUERY_ERROR(103,"查询数据错误"),
    DELETE_ERROR(104,"删除数据错误")
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
