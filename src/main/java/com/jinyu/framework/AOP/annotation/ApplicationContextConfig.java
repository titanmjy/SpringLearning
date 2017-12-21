package com.jinyu.framework.AOP.annotation;

import com.jinyu.framework.AOP.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/12/11 10:57
 * Version: V0.1
 */

@Configuration
@EnableAspectJAutoProxy
public class ApplicationContextConfig {


    /**
     * 核心逻辑bean
     * @return
     */
    @Bean
    ProductService productService(){
        return new ProductService();
    }

    /**
     * 切面bean
     * @return
     */
    @Bean
    MyAspect1 myAspect(){
        return new MyAspect1();
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
        ProductService productService = (ProductService) ctx.getBean("productService");
        productService.doSomething();

        // with param
        productService.output(5);
        Param p = new Param();
        p.setName("aaa");
        productService.outputObject(p);
    }
}
