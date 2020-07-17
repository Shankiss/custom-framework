package com.zyuc.demo.service.impl;

import com.zyuc.demo.dao.UserMapper;
import com.zyuc.demo.model.User;
import com.zyuc.demo.service.UserService;
import com.zyuc.demo.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
* @Description TODO
* @Date 2020/07/02 17:33:34
* @Created by ChenHao
* @Copyright Copyright (c) zyuc
*/
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

}
