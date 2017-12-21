package com.jinyu.framework.AOP.JoinPointTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;


/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/12/11 10:57
 * Version: V0.1
 */

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.jinyu.framework.AOP.JoinPointTest")
public class ApplicationContextConfig {

//    @Bean
//    AopAspect myAspect(){
//        return new AopAspect();
//    }
//
//    @Bean
//    TargetClass targetClass(){
//        return new TargetClass();
//    }

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
        TargetClass targetClass = (TargetClass) ctx.getBean("targetClass");
        String result = targetClass.joint("spring","aop");
        System.out.println("result:" + result);
    }
}
