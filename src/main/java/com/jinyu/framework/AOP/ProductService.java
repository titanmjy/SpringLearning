package com.jinyu.framework.AOP;

import com.jinyu.framework.AOP.annotation.Param;

/**
 * 核心业务逻辑
 *
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/12/11 10:03
 * Version: V0.1
 */
public class ProductService {

    public void doSomething(){
        System.out.println("in do something");
    }

    public void output(int a){
        System.out.println("in output :" + a);
    }


    public void outputObject(Param p){
        System.out.println("in outputObject :" + p.getName());
    }
}
