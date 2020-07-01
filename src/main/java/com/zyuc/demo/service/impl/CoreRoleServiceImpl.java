package com.zyuc.demo.service.impl;

import com.zyuc.demo.common.ErrorEnum;
import com.zyuc.demo.common.ZyException;
import com.zyuc.demo.entity.CoreRole;
import com.zyuc.demo.dao.CoreRoleDao;
import com.zyuc.demo.service.CoreRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CoreRole)表服务实现类
 *
 * @author makejava
 * @since 2020-04-27 17:56:42
 */
@Service("coreRoleService")
public class CoreRoleServiceImpl implements CoreRoleService {
    @Resource
    private CoreRoleDao coreRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CoreRole queryById(Integer id) {
//        if(id==null){
//            throw new ZyException(ErrorEnum.NULL_PARAMS);
//        }
        return this.coreRoleDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<CoreRole> queryAllByLimit(int offset, int limit) {
        return this.coreRoleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param coreRole 实例对象
     * @return 实例对象
     */
    @Override
    public CoreRole insert(CoreRole coreRole) {
        this.coreRoleDao.insert(coreRole);
        return coreRole;
    }

    /**
     * 修改数据
     *
     * @param coreRole 实例对象
     * @return 实例对象
     */
    @Override
    public CoreRole update(CoreRole coreRole) {
        this.coreRoleDao.update(coreRole);
        return this.queryById(coreRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.coreRoleDao.deleteById(id) > 0;
    }

}