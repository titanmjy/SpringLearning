package com.jinyu.JPA.nativeJPA.dao.base;

import org.hibernate.Session;

import java.util.List;

/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/9/22 11:34
 * Version: V0.1
 */
public interface BaseDao<T> {

    public Session getSession();

    public T findById(Object id);
    
    public Integer save(T t);
    
    public void update(T t);
    
    public void delete(Object id);
    
    public List<T> findAll();
    
    public Integer count();
}
