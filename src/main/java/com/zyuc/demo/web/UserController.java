package com.zyuc.demo.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyuc.demo.annotation.MyLog;
import com.zyuc.demo.common.ResponseMsg;
import com.zyuc.demo.model.User;
import com.zyuc.demo.service.UserService;
import com.zyuc.demo.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.zyuc.demo.constant.DigitalConstant.DEFAULT_PAGE_NUM;
import static com.zyuc.demo.constant.DigitalConstant.DEFAULT_PAGE_SIZE;

/**
 * @Description TODO
 * @Date 2020/07/02 17:33:34
 * @Created by ChenHao
 * @Copyright Copyright (c) zyuc
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    @MyLog(description = "新增用户")
    public ResponseMsg add(@RequestBody User user) {
        userService.save(user);
        return ResponseUtil.success();
    }

    @DeleteMapping("/{id}")
    @MyLog(description = "删除用户")
    public ResponseMsg delete(@PathVariable Integer id) {
        userService.deleteById(id);
        return ResponseUtil.success();
    }

    @PutMapping
    @MyLog(description = "修改用户")
    public ResponseMsg update(@RequestBody User user) {
        userService.update(user);
        return ResponseUtil.success();
    }

    @GetMapping("/{id}")
    @MyLog(description = "检索用户详情")
    public ResponseMsg detail(@PathVariable Integer id) {
        User user = userService.findById(id);
        return ResponseUtil.success(user);
    }

    @GetMapping
    @MyLog(description = "检索用户列表")
    public ResponseMsg list(@RequestParam(defaultValue = DEFAULT_PAGE_NUM) Integer page,
                            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResponseUtil.success(pageInfo);
    }

}
