package com.jinyu.framework.DataAccess.model;

/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/11/28 16:06
 * Version: V0.1
 */
public class WebSite {

    private Integer id;

    private String name;

    private String url;

    private Integer alexa;

    private String country;
}





/**
CREATE TABLE `websites` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` char(20) NOT NULL DEFAULT '' COMMENT '站点名称',
    `url` varchar(255) NOT NULL DEFAULT '',
    `alexa` int(11) NOT NULL DEFAULT '0' COMMENT 'Alexa 排名',
    `country` char(10) NOT NULL DEFAULT '' COMMENT '国家',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
*/