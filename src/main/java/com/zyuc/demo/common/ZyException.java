package com.zyuc.demo.common;

/**
 * @Version 1.0
 * @Description 自定义异常
 * @Date 2020/5/8 13:42
 * @Created by ChenHao
 */
public class ZyException extends RuntimeException {

    private Integer code;

    public ZyException(ErrorEnum errorEnum) {
        super(errorEnum.getMsg());
        this.code = errorEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
