package com.jinyu.DataAccess.service;

import com.jinyu.DataAccess.dao.WebSiteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/11/28 15:32
 * Version: V0.1
 */

@Service
public class WebSiteService {

    @Autowired
    private WebSiteDao webSiteDao;


    public void addWebSite(){
        this.webSiteDao.add();
    }


    public List<Map<String,Object>> getWebSites(){
        return this.webSiteDao.get();
    }
}
