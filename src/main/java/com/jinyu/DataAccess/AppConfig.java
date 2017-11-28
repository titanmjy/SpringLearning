package com.jinyu.DataAccess;

import com.jinyu.DataAccess.dao.WebSiteDao;
import com.jinyu.DataAccess.dao.WebSiteDaoImpl;
import com.jinyu.DataAccess.service.WebSiteService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/11/28 14:59
 * Version: V0.1
 */

@Configuration
public class AppConfig {


    @Bean
    public DataSource druidDataSource(){
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl("jdbc:mysql://172.16.103.201:3306/test");
        datasource.setUsername("root");
        datasource.setPassword("!QAZxsw2");
        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setInitialSize(1);
        datasource.setMinIdle(1);
        datasource.setMaxActive(20);
        datasource.setMaxWait(60000);
        datasource.setTimeBetweenEvictionRunsMillis(60000);
        datasource.setMinEvictableIdleTimeMillis(300000);
        datasource.setValidationQuery("SELECT 'x'");
        datasource.setTestWhileIdle(true);
        datasource.setTestOnBorrow(false);
        datasource.setTestOnReturn(false);
        return datasource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(this.druidDataSource());
    }

    @Bean
    public WebSiteService webSiteService(){
        return new WebSiteService();
    }

    @Bean
    public WebSiteDao webSiteDao(){
        return new WebSiteDaoImpl();
    }


    public static void main(String[] args){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        WebSiteService wservice = (WebSiteService)ctx.getBean("webSiteService");
//        wservice.addWebSite();
        List<Map<String, Object>> webSites = wservice.getWebSites();
        Map<String,Object> first = webSites.get(1);
        System.out.println(first.get("id"));
    }
}
