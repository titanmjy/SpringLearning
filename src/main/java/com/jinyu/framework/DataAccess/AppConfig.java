package com.jinyu.framework.DataAccess;

import com.jinyu.framework.DataAccess.dao.WebSiteDao;
import com.jinyu.framework.DataAccess.dao.WebSiteDaoImpl;
import com.jinyu.framework.DataAccess.service.WebSiteService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/11/28 14:59
 * Version: V0.1
 */

@Configuration
@EnableTransactionManagement
public class AppConfig {


    /**
     * 数据源
     * @return
     */
    @Bean
    public DataSource druidDataSource(){
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
        datasource.setUsername("root");
        datasource.setPassword("password");
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

    /**
     * service
     * @return
     */
    @Bean
    public WebSiteService webSiteService(){
        return new WebSiteService();
    }

    /**
     * dao
     * @return
     */
    @Bean
    public WebSiteDao webSiteDao(){
        return new WebSiteDaoImpl();
    }


//    事务管理测试
    /**
     * 事务管理器
     * @return
     */
    @Bean
    public PlatformTransactionManager txManager(){
        return new DataSourceTransactionManager(druidDataSource());
    }


    public static void main(String[] args){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        WebSiteService wservice = (WebSiteService)ctx.getBean("webSiteService");
        wservice.addWebSite();
//        List<Map<String, Object>> webSites = wservice.getWebSites();
//        Map<String,Object> first = webSites.get(0);
//        System.out.println(first.get("id"));
    }
}
