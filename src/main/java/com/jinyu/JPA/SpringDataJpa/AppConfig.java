package com.jinyu.JPA.SpringDataJpa;

import com.jinyu.JPA.SpringDataJpa.model.WebSite;
import com.jinyu.JPA.SpringDataJpa.dao.WebSiteRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/12/22 9:34
 * Version: V0.1
 */
@Configuration
@EnableJpaRepositories("com.jinyu.JPA.SpringDataJpa.dao")
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


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(this.dataSource());
        factory.setJpaVendorAdapter(this.hibernateJpaVendorAdapter());
        factory.setPackagesToScan("com.jinyu.JPA");
        Map<String,Object> jpaProperty = new HashMap();
        jpaProperty.put("hibernate.ejb.naming_strategy","org.hibernate.cfg.ImprovedNamingStrategy");
        jpaProperty.put("hibernate.dialect","org.hibernate.dialect.MySQL5InnoDBDialect");
        jpaProperty.put("hibernate.show_sql",true);
        jpaProperty.put("hibernate.format_sql",true);
        jpaProperty.put("hibernate.hbm2ddl.auto","update");
        factory.setJpaPropertyMap(jpaProperty);
        return factory;
    }


    @Bean
    public HibernateJpaVendorAdapter hibernateJpaVendorAdapter(){
        return new HibernateJpaVendorAdapter();
    }


    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        WebSiteRepository reposity = ctx.getBean(WebSiteRepository.class);
        WebSite google = reposity.findByName("Google");
        WebSite site = reposity.findByCountry("cn").get(0);
        System.out.println(site.toString());
    }

}
