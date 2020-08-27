package com.zyuc.demo.core;

import java.util.List;

/**
 * @Version 1.0
 * @Description 通用Mapper接口
 * @Date 2020/7/2 10:10
 * @Created by ChenHao
 */
public interface IMapper<T> {

    T get(Integer id);

    int insert(T model);

    int update(T model);

    int delete(Integer id);

    List<T> page (T model);

}
