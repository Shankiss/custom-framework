package com.zyuc.demo.controller;

import com.zyuc.demo.annotation.MyLog;
import com.zyuc.demo.common.ResponseMsg;
import com.zyuc.demo.common.ServiceException;
import com.zyuc.demo.utils.ResponseUtil;
import com.zyuc.demo.entity.User;
import com.zyuc.demo.service.IUserService;
import com.zyuc.demo.dto.base.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* @Description TODO
* @Date 2020/08/27 17:19:05
* @Created by ChenHao
* @Copyright Copyright (c) zyuc
*/
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping
    @MyLog(description = "新增用户")
    public ResponseMsg insert(@RequestBody User user) {
        try {
            return ResponseUtil.success(userService.insert(user));
        } catch (ServiceException e) {
            return ResponseUtil.error(e);
        }
    }

    @DeleteMapping("/{id}")
    @MyLog(description = "删除用户")
    public ResponseMsg delete(@PathVariable Integer id) {
        try {
            userService.delete(id);
            return ResponseUtil.success();
        } catch (ServiceException e) {
            return ResponseUtil.error(e);
        }
    }

    @PutMapping
    @MyLog(description = "修改用户")
    public ResponseMsg update(@RequestBody User user) {
        try {
        userService.update(user);
            return ResponseUtil.success();
        } catch (ServiceException e) {
            return ResponseUtil.error(e);
        }
    }

    @GetMapping("/{id}")
    @MyLog(description = "检索用户详情")
    public ResponseMsg get(@PathVariable Integer id) {
        try {
            return ResponseUtil.success(userService.get(id));
        } catch (ServiceException e) {
            return ResponseUtil.error(e);
        }
    }

    @GetMapping
    @MyLog(description = "检索用户列表")
    public ResponseMsg page(User user, PageBean pageBean) {
        try {
            PageHelper.startPage(pageBean.getPageNum(), pageBean.getPageSize());
            List<User> list = userService.page(user);
            return ResponseUtil.success(new PageInfo(list));
        } catch (ServiceException e) {
            return ResponseUtil.error(e);
        }
    }

}
