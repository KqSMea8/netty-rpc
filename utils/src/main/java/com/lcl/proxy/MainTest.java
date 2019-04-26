package com.lcl.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author liuchunli3
 * @date 2019/4/25 16:56
 */
public class MainTest {


    public static void main(String[] args){

        IPerson person = (IPerson) DynaProxyFactory.getProxy(new ZhangSan());

        person.say("你好");
        person.eat("苹果");

        //不能代理无接口类
        /*Cat cat = (Cat) DynaProxyFactory.getProxy(new Cat());
        cat.eat("鱼");*/
    }
}
