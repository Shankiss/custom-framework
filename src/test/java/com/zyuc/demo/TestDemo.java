package com.zyuc.demo;

import com.alibaba.fastjson.JSON;
import com.zyuc.demo.model.User;
import com.zyuc.demo.service.UserService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Version 1.0
 * @Description TODO
 * @Date 2020/7/17 11:11
 * @Created by ChenHao
 */
public class TestDemo extends Tester {

    private static final Logger logger = LoggerFactory.getLogger(TestDemo.class);

    @Autowired
    private UserService userService;

    @Test
    public void getUser() {
        User user = userService.findById(1);

        logger.info("OUTPUT PARAMS >>>>>>>>>>> {}", JSON.toJSONString(user));

    }

}
