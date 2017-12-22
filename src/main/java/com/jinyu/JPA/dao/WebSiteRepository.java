package com.jinyu.JPA.dao;

import com.jinyu.JPA.model.WebSite;
import com.sun.tools.javac.util.List;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;

/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/12/22 10:09
 * Version: V0.1
 */
public interface WebSiteRepository extends Repository<WebSite,Integer> {
    WebSite findByName(String name);
    ArrayList<WebSite> findByCountry(String country);
}
