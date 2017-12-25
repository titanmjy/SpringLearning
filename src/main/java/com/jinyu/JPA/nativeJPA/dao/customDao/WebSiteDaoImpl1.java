package com.jinyu.JPA.nativeJPA.dao.customDao;

import com.jinyu.JPA.nativeJPA.dao.base.BaseDaoImpl;
import com.jinyu.JPA.nativeJPA.model.WebSite;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/12/25 10:29
 * Version: V0.1
 */
@Component("webSiteDao1")
public class WebSiteDaoImpl1 extends BaseDaoImpl<WebSite> implements WebSiteDao1 {


}
