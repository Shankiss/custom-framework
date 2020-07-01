package com.zyuc.demo.dao;

import com.zyuc.demo.entity.CoreRole;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (CoreRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-27 17:56:41
 */
public interface CoreRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CoreRole queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CoreRole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param coreRole 实例对象
     * @return 对象列表
     */
    List<CoreRole> queryAll(CoreRole coreRole);

    /**
     * 新增数据
     *
     * @param coreRole 实例对象
     * @return 影响行数
     */
    int insert(CoreRole coreRole);

    /**
     * 修改数据
     *
     * @param coreRole 实例对象
     * @return 影响行数
     */
    int update(CoreRole coreRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}