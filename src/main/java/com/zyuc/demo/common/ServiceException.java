package com.zyuc.demo.common;

import com.zyuc.demo.enums.ErrorEnum;

/**
 * @Version 1.0
 * @Description 自定义异常
 * @Date 2020/5/8 13:42
 * @Created by ChenHao
 */
public class ServiceException extends RuntimeException {

    private Integer code;

    public ServiceException(ErrorEnum errorEnum) {
        super(errorEnum.getMsg());
        this.code = errorEnum.getCode();
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
