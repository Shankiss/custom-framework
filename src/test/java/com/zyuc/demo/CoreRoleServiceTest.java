package com.zyuc.demo;

import com.zyuc.demo.entity.CoreRole;
import com.zyuc.demo.service.CoreRoleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Version 1.0
 * @Description TODO
 * @Date 2020/5/8 15:43
 * @Created by ChenHao
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CoreRoleServiceTest {

    @Autowired
    private CoreRoleService coreRoleService;

    @Test
    public void findOne() throws Exception {
        CoreRole coreRole = coreRoleService.queryById(2);
        Assert.assertEquals("CEO",coreRole.getCode());
    }
}
