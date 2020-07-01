package com.zyuc.demo.service;

import com.zyuc.demo.entity.CoreRole;
import java.util.List;

/**
 * (CoreRole)表服务接口
 *
 * @author makejava
 * @since 2020-04-27 17:56:42
 */
public interface CoreRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CoreRole queryById(Integer id) throws Exception;

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CoreRole> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param coreRole 实例对象
     * @return 实例对象
     */
    CoreRole insert(CoreRole coreRole);

    /**
     * 修改数据
     *
     * @param coreRole 实例对象
     * @return 实例对象
     */
    CoreRole update(CoreRole coreRole) throws Exception;

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}