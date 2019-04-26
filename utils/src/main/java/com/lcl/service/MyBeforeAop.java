package com.lcl.service;

//MyBeforeAop.java  定义aop处理方法

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class MyBeforeAop implements MethodBeforeAdvice, AfterReturningAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("before aop ["+method.getName()+"] do sth...................");
    }


    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("afterReturning aop ["+method.getName()+"] do sth...................");
    }
}

