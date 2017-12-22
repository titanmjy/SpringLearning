package com.jinyu.JPA.model;

import javax.persistence.*;

/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/11/28 16:06
 * Version: V0.1
 */
@Entity
@Table(name = "websites")
public class WebSite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @Column(name = "alexa")
    private Integer alexa;

    @Column(name = "country")
    private String country;

    @Override
    public String toString() {
        return "WebSite{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", alexa=" + alexa +
                ", country='" + country + '\'' +
                '}';
    }
}


/**
 * CREATE TABLE `websites` (
 * `id` int(11) NOT NULL AUTO_INCREMENT,
 * `name` char(20) NOT NULL DEFAULT '' COMMENT '站点名称',
 * `url` varchar(255) NOT NULL DEFAULT '',
 * `alexa` int(11) NOT NULL DEFAULT '0' COMMENT 'Alexa 排名',
 * `country` char(10) NOT NULL DEFAULT '' COMMENT '国家',
 * PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
 */