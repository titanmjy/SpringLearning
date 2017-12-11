package com.jinyu.AOP.configFile;

import com.jinyu.AOP.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/12/11 13:09
 * Version: V0.1
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("D:\\ideaProject\\springLearning\\src\\main\\java\\com\\jinyu\\AOP\\configFile\\applicationContext.xml");
//        ApplicationContext context = new ClassPathXmlApplicationContext("file:D:\\ideaProject\\springLearning\\src\\main\\java\\com\\jinyu\\AOP\\configFile\\applicationContext.xml");
        ProductService productService = (ProductService) context.getBean("productService");
        productService.doSomething();
    }
}
