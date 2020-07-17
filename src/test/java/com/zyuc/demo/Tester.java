package com.zyuc.demo;


import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


/**
 * @Version 1.0
 * @Description 单元测试继承该类即可
 * @Date 2020/7/2 11:10
 * @Created by ChenHao
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@Transactional
@Rollback
public abstract class Tester {}



