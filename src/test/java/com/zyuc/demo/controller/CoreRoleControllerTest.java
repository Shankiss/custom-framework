package com.zyuc.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


/**
 * @Version 1.0
 * @Description TODO
 * @Date 2020/5/8 15:54
 * @Created by ChenHao
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CoreRoleControllerTest {

    private final static Logger logger = LoggerFactory.getLogger(CoreRoleControllerTest.class);

    @Autowired
    private MockMvc mvc;

    @Test
    public void selectOne() throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/coreRole/selectOne").param("id", "2")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        logger.info("测试返回{}", result.toString());
    }
}