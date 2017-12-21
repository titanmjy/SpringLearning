package com.jinyu.AOP.annotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/12/11 11:03
 * Version: V0.1
 */
@Aspect
public class MyAspect1 {

//    @Before("execution(* com.jinyu.AOP.ProductService.doSomething(..))")
//    public void doAccessCheck() {
//        System.out.println("in before check");
//    }
//
//    @After("execution(* com.jinyu.AOP.ProductService.doSomething(..))")
//    public void checkAfter(){
//        System.out.println("after check");
//    }

    /**
     * 通知关联切点名
     * */
    @Before("doSomething()")
    public void doAccessCheck() {
        System.out.println("in before check");
    }

    @After("doSomething()")
    public void checkAfter(){
        System.out.println("after check");
    }

    /**
     * 定义切点名
     * */
    @Pointcut("execution(* com.jinyu.AOP.ProductService.doSomething(..))")
    public void doSomething(){}

}
