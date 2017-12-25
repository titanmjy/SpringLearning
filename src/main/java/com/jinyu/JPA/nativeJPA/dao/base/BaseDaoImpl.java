package com.jinyu.JPA.nativeJPA.dao.base;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/9/22 11:35
 * Version: V0.1
 */
public class BaseDaoImpl<T> implements BaseDao<T>{

    @Autowired
    SessionFactory sessionFactory;

    private Class<T> clazz;  
    
    @SuppressWarnings("unchecked")  
    public BaseDaoImpl(){  
        //使用反射技术得到T的真实类型  
        //获取当前new的对象的泛型的父类  
        ParameterizedType pt =(ParameterizedType) this.getClass().getGenericSuperclass();  
        //获取第一个类型参数的真实类型  
        this.clazz = (Class<T>) pt.getActualTypeArguments()[0];  
     } 
    
    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public T findById(Object id) {
          return (T) this.getSession().find(clazz, id);
    }

	public Integer save(T t) {
		return (Integer) this.getSession().save(t);
	}

	public void update(T t) {
		this.getSession().update(t);
	}

	public void delete(Object id) {
		this.getSession().delete(id);
	}

	public List<T> findAll() {
		String hql = "from "+clazz.getSimpleName();
		Query<T> query = this.getSession().createQuery(hql);
		return query.list();
	}

	public Integer count() {
		String hql="select count(*) from "+clazz.getSimpleName();
		Query<T> query=this.getSession().createQuery(hql);
		List<T> list=query.list();
		Long result=(Long) list.get(0);
		return result.intValue();
	}

}
