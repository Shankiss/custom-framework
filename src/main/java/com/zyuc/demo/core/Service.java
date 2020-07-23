package com.zyuc.demo.core;

import java.util.List;

/**
 * @Version 1.0
 * @Description Service 层 基础接口，其他Service 接口 请继承该接口
 * @Date 2020/7/2 10:30
 * @Created by ChenHao
 */
public interface Service<T> {
    void save(T model);//持久化

    void save(List<T> models);//批量持久化

    void deleteById(Integer id);//通过主鍵刪除

    void deleteByIds(String ids);//批量刪除 eg：ids -> “1,2,3,4”

    void update(T model);//更新

    T qryById(Integer id);//通过ID查找

    List<T> qryByIds(String ids);//通过多个ID查找//eg：ids -> “1,2,3,4”

    List<T> page(T t);

    List<T> qryAll();//获取所有
}
