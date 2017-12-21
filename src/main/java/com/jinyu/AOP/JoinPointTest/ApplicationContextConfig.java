package com.jinyu.AOP.JoinPointTest;

import com.jinyu.AOP.ProductService;
import com.jinyu.AOP.annotation.MyAspect1;
import com.jinyu.AOP.annotation.Param;
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

    @Bean
    AopAspect myAspect(){
        return new AopAspect();
    }

    @Bean
    TargetClass targetClass(){
        return new TargetClass();
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
        TargetClass targetClass = (TargetClass) ctx.getBean("targetClass");
        String result = targetClass.joint("spring","aop");
        System.out.println("result:" + result);
    }
}
