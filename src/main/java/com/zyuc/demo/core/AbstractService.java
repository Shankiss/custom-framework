package com.zyuc.demo.core;


import com.zyuc.demo.common.ServiceException;
import com.zyuc.demo.enums.ErrorEnum;

import javax.annotation.Resource;
import java.util.List;


/**
 *  泛型注入mapper实现通用方法
 */
public abstract class AbstractService<T> implements IService<T> {

    @Resource
    protected IMapper<T> mapper;

    public T insert(T model) throws ServiceException {
        try {
            int result =  mapper.insert(model);
            if(result<=0){
                throw new ServiceException(ErrorEnum.INSERT_ERROR);
            }
            return model;
        } catch (Exception e) {
            throw new ServiceException(ErrorEnum.INSERT_ERROR,e);
        }
    }

    public boolean update(T model) throws ServiceException{
        try {
            int result = mapper.update(model);
            if (result <= 0)
                return false;
        } catch (Exception e) {
            throw new ServiceException(ErrorEnum.UPDATE_ERROR,e);
        }
        return true;
    }

    public T get(Integer id) throws ServiceException{
        try {
            return mapper.get(id);
        } catch (Exception e) {
            throw new ServiceException(ErrorEnum.QUERY_ERROR,e);
        }
    }

    public List<T> page(T model) throws ServiceException {
        try {
            return mapper.page(model);
        } catch (Exception e) {
            throw new ServiceException(ErrorEnum.QUERY_ERROR, e);
        }
    }

    public boolean delete(Integer id) throws ServiceException{
        try {
            int result = mapper.delete(id);
            if (result <= 0)
                return false;
        } catch (Exception e) {
            throw new ServiceException(ErrorEnum.DELETE_ERROR,e);
        }
        return true;
    }

}
