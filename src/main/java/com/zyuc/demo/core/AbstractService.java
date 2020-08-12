package com.zyuc.demo.core;


import javax.annotation.Resource;


/**
 *  泛型注入mapper实现通用方法
 */
public abstract class AbstractService<T> implements IService<T> {

    @Resource
    protected IMapper<T> mapper;

    public int insert(T model) {
        return mapper.insert(model);
    }

    public int delete(Integer id) {
        return mapper.delete(id);
    }

    public int update(T model) {
        return mapper.update(model);
    }

    public T get(Integer id) {
        return mapper.get(id);
    }

}
