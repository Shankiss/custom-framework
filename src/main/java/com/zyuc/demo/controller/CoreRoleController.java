package com.zyuc.demo.controller;

import com.zyuc.demo.annotation.MyLog;
import com.zyuc.demo.common.ResponseMsg;
import com.zyuc.demo.entity.CoreRole;
import com.zyuc.demo.entity.User;
import com.zyuc.demo.service.CoreRoleService;
import com.zyuc.demo.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CoreRole)表控制层
 *
 * @author makejava
 * @since 2020-04-27 17:56:42
 */
@RestController
@RequestMapping("coreRole")
public class CoreRoleController {
    /**
     * 服务对象
     */
    @Resource
    private CoreRoleService coreRoleService;

    @Autowired
    private User user;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @MyLog(description = "主键检索核心角色")
    @GetMapping("selectOne")
    public ResponseMsg<CoreRole> selectOne(Integer id) throws Exception{
//        User bean = new User();
//        BeanUtils.copyProperties(user,bean);
//        return ResponseUtil.success(bean);

        return ResponseUtil.success(coreRoleService.queryById(id));
    }

    @GetMapping("queryAllByLimit")
    public List<CoreRole> queryAllByLimit(int offset, int limit) {
        return coreRoleService.queryAllByLimit(offset, limit);
    }


}