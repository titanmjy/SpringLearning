package com.jinyu.JPA.nativeJPA;


import com.jinyu.JPA.nativeJPA.dao.WebSiteDao;
import com.jinyu.JPA.nativeJPA.dao.WebSiteDaoImpl;
import com.jinyu.JPA.nativeJPA.model.WebSite;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import java.util.Properties;

/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/12/22 9:34
 * Version: V0.1
 */
@Configuration
@ComponentScan(basePackages = "com.jinyu.JPA.nativeJPA.dao")
public class AppConfig {

    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://172.16.103.201:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("!QAZxsw2");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }


    @Bean("sessionFactory")
    public LocalSessionFactoryBean factoryBean(){
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(this.dataSource());
        String[] packages = {"com.jinyu.JPA.nativeJPA.model"};
        factoryBean.setPackagesToScan(packages);

        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect","org.hibernate.dialect.Oracle12cDialect");
        hibernateProperties.put("hibernate.show_sql",true);
        hibernateProperties.put("hbm2ddl.auto","update");
        factoryBean.setHibernateProperties(hibernateProperties);

        return factoryBean;
    }


    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        WebSiteDaoImpl webSiteDao = (WebSiteDaoImpl) ctx.getBean("webSiteDao");
        WebSite site = webSiteDao.getHibernateTemplate().get(WebSite.class,1);
        System.out.println(site.toString());
    }

}
