package com.lcl.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author liuchunli3
 * 动态代理
 * 通过InvocationHandler接口实现的动态代理只能代理接口的实现类
 * @date 2019/4/25 16:48
 */
public class DynaProxyHandler implements InvocationHandler {

    private Object target;//被代理对象
    public void setTarget(Object target) {
        this.target = target;
    }
    public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
        System.out.println("执行开始时间:" + new Date());
        Object result = method.invoke(target, args);
        System.out.println("执行结束时间:" + new Date());
        return result;//返回method执行结果
    }

}
