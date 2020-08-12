package com.zyuc.demo.controller;

import com.zyuc.demo.annotation.MyLog;
import com.zyuc.demo.common.ResponseMsg;
import com.zyuc.demo.service.IUserService;
import com.zyuc.demo.utils.ResponseUtil;
import com.zyuc.demo.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* @Description TODO
* @Date 2020/08/12 15:13:43
* @Created by ChenHao
* @Copyright Copyright (c) zyuc
*/
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @DeleteMapping("/{id}")
    @MyLog(description = "删除用户")
    public ResponseMsg delete(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseUtil.success();
    }

    @GetMapping("/{id}")
    @MyLog(description = "检索用户详情")
    public ResponseMsg detail(@PathVariable Integer id) {
        User user = userService.get(id);
        return ResponseUtil.success(user);
    }

}
