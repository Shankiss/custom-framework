package com.zyuc.demo.core;

/**
 * @Version 1.0
 * @Description Service 层 基础接口，其他Service 接口 请继承该接口
 * @Date 2020/7/2 10:30
 * @Created by ChenHao
 */
public interface IService<T> {

    int insert(T model);

    int update(T model);

    int delete(Integer id);

    T get(Integer id);

}
