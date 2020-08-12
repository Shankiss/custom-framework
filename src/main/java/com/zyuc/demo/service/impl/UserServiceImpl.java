package com.zyuc.demo.service.impl;

import com.zyuc.demo.core.AbstractService;
import com.zyuc.demo.entity.User;
import com.zyuc.demo.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* @Description TODO
* @Date 2020/08/12 15:08:50
* @Created by ChenHao
* @Copyright Copyright (c) zyuc
*/
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements IUserService {

}
