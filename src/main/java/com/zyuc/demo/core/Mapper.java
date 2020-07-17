package com.zyuc.demo.core;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * @Version 1.0
 * @Description 定制版MyBatis Mapper插件接口，如需其他接口参考官方文档自行添加。
 * @Date 2020/7/2 10:10
 * @Created by ChenHao
 */
public interface Mapper<T>
        extends
        BaseMapper<T>,
        ConditionMapper<T>,
        IdsMapper<T>,
        InsertListMapper<T> {
}
