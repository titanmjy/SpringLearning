package com.jinyu.JPA.nativeJPA.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/11/28 15:28
 * Version: V0.1
 */
@Component("webSiteDao")
public class WebSiteDaoImpl extends HibernateDaoSupport implements WebSiteDao {


    @Resource(name="sessionFactory")
    public void setSessionFactoryDI(SessionFactory sessionFactory) {
        //调用父类的setSessionFactory方法,注入sessionFactory
        super.setSessionFactory(sessionFactory);
    }

//    这样注入会话工厂是不行的
//    @Autowired
//    private SessionFactory sessionFactory;
}
