package com.jinyu.JPA.SpringDataJpa.dao;

import com.jinyu.JPA.SpringDataJpa.model.WebSite;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;

/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/12/22 10:09
 * Version: V0.1
 *
 * Repository<WebSite,Integer>
 *              实体类  id类型
 */
public interface WebSiteRepository extends Repository<WebSite,Integer> {
    WebSite findByName(String name);
    ArrayList<WebSite> findByCountry(String country);
}
