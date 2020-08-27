package com.zyuc.demo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * @Version 1.0
 * @Description TODO
 * @Date 2020/7/17 11:11
 * @Created by ChenHao
 */
public class TestDemo extends Tester {

    private static final Logger logger = LoggerFactory.getLogger(TestDemo.class);

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testUser() {
        String url = "http://localhost:18068/test/api/user/";

        //新增用户

        //删除用户

        //修改用户

        //查询单个用户
//        User user = restTemplate.getForObject(url + 1, User.class);
//        logger.info(">>>>>>>>>>>>> 请求url，{}", url + 1);
//        logger.info(">>>>>>>>>>>>> 返回信息，{}", JSON.toJSONString(user));

        //查询用户列表
//        User user = new User();
//        user.setNickName("土豆-1");
//        List<User> list = (List<User>) restTemplate.getForObject(url, User.class, user);
        logger.info(">>>>>>>>>>>>> 请求url，{}", url + 1);
//        logger.info(">>>>>>>>>>>>> 返回信息，{}", JSON.toJSONString(restTemplate.getForObject(url, User.class, user)));

    }

}
