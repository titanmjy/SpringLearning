package com.jinyu.DataAccess.dao;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/11/28 15:15
 * Version: V0.1
 */
public interface WebSiteDao {

    public List<Map<String, Object>> get();

    public void add();

}
