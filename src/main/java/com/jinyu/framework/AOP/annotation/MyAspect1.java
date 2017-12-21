package com.jinyu.framework.AOP.annotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/12/11 11:03
 * Version: V0.1
 */
@Aspect
public class MyAspect1 {

//    @Before("execution(* com.jinyu.framework.AOP.ProductService.doSomething(..))")
//    public void doAccessCheck() {
//        System.out.println("in before check");
//    }
//
//    @After("execution(* com.jinyu.framework.AOP.ProductService.doSomething(..))")
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
    @Pointcut("execution(* com.jinyu.framework.AOP.ProductService.doSomething(..))")
    public void doSomething(){}


    /**
     * 通知传参
     * 两种写法，切点表达式包含args，就不需要argNames参数
     * 传一个基本类型
     * */
//    @Before(value = "execution(* com.jinyu.framework.AOP.ProductService.output(..)) && args(a)",argNames = "a")
    @Before("execution(* com.jinyu.framework.AOP.ProductService.output(..)) && args(a, ..)")
    public void outputCheckParam(int a){
        System.out.println("i got the param:" + a);
    }


    /**
     * 传一个对象
     * @param p
     */
    @Before(value = "execution(* com.jinyu.framework.AOP.ProductService.outputObject(..)) && args(p,..)")
    public void objectParamCheck(Param p){
        System.out.println("i got the Param :" + p.getName());
    }

}
