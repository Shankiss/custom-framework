package com.zyuc.demo.utils;

import com.zyuc.demo.common.ResponseMsg;
import com.zyuc.demo.enums.StateEnum;

/**
 * @Version 1.0
 * @Description 统一处理返回信息
 * @Date 2020/5/7 16:22
 * @Created by ChenHao
 */
public class ResponseUtil {

    public static ResponseMsg success(){
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setCode(StateEnum.SUCCESS.getCode());
        responseMsg.setMsg(StateEnum.SUCCESS.getMsg());
        return responseMsg;
    }

    public static ResponseMsg success(Object object) {
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setCode(StateEnum.SUCCESS.getCode());
        responseMsg.setMsg(StateEnum.SUCCESS.getMsg());
        responseMsg.setData(object);
        return responseMsg;
    }

    public static ResponseMsg error(Integer code, String msg) {
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setCode(code);
        responseMsg.setMsg(msg);
        return responseMsg;
    }
}
