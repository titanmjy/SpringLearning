package com.jinyu.framework.DataAccess.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/11/28 15:28
 * Version: V0.1
 */
@Repository
@Transactional
public class WebSiteDaoImpl implements WebSiteDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> get() {
        /* queryForList查询结果是一个Map,需要把map转换成对应得实体类*/
        return this.jdbcTemplate.queryForList("select * from website");
    }

    @Override
    public void add() {
        String sql = "insert into website(id,name,url,alexa,country) values(5,'ahaha','http://www.baidu.com',123,'cn')";
        this.jdbcTemplate.execute(sql);
        String sql2 = "insert into website1(id,name) values(2,'test')";
        this.jdbcTemplate.execute(sql2);
    }
}
