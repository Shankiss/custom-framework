package com.zyuc.demo.utils;

import com.zyuc.demo.common.Constants;
import com.zyuc.demo.common.ResponseMsg;

/**
 * @Version 1.0
 * @Description 统一处理返回信息
 * @Date 2020/5/7 16:22
 * @Created by ChenHao
 */
public class ResponseUtil {

    public static ResponseMsg success(Object object) {
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setCode(Constants.SUCCESS_CODE);
        responseMsg.setMsg("成功");
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
