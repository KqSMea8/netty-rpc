package com.lcl.proxy;

/**
 * @author liuchunli3
 * @date 2019/4/25 17:01
 */
public class Cat {
    public String eat(String food) {
        String ret = "猫吃:"+food;
        System.out.println(ret);
        return ret;
    }
}
