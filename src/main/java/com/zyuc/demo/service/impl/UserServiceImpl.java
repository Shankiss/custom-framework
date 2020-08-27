package com.zyuc.demo.service.impl;

import com.zyuc.demo.repository.IUserMapper;
import com.zyuc.demo.entity.User;
import com.zyuc.demo.service.IUserService;
import com.zyuc.demo.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
* @Description TODO
* @Date 2020/08/27 17:19:05
* @Created by ChenHao
* @Copyright Copyright (c) zyuc
*/
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements IUserService {

    @Resource
    private IUserMapper userMapper;

}
