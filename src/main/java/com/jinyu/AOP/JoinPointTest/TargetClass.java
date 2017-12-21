package com.jinyu.AOP.JoinPointTest;

import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author jinyu.mei
 * @Date 2017/12/21 13:32
 * Version: V0.1
 */
public class TargetClass {

    public String joint(String str1, String str2) {
        System.out.println("in joint() " + str1 + " " + str2);
        return str1 + "+" + str2;
    }
}
