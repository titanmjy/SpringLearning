package com.jinyu.framework.AOP.configFile;

/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/12/11 13:08
 * Version: V0.1
 */
public class MyAspect {

    public void doAccessCheck() {
        System.out.println("in before check");
    }

    public void checkAfter(){
        System.out.println("after check");
    }
}
