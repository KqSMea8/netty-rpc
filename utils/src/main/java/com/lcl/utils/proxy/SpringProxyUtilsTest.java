package com.lcl.utils.proxy;

import com.lcl.proxy.*;
import com.lcl.service.ServiceInter;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liuchunli3
 * @date 2019/4/25 18:12
 */
public class SpringProxyUtilsTest {


    public static void main(String[] args) throws Exception {
        /*Cat cat = new Cat();
        Class targetClass = SpringProxyUtils.getTargetClass(cat);
        Cat cat1 = (Cat) targetClass.newInstance();
        cat1.eat("鱼1");*/

        /*CglibProxy cglib = new CglibProxy();//实例化CglibProxy对象
        Cat cat2 =  (Cat) cglib.getCglibProxy(new Cat());//获取代理对象
        Class targetClass2 = SpringProxyUtils.getTargetClass(cat2);
        Cat cat2Proxy = (Cat) targetClass2.newInstance();
        cat2Proxy.eat("鱼2");*/

        SpringProxyUtilsTest.test();
    }


    public static void test() throws Exception {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("com.lcl");

        //aop3  实际的spring使用aop的过程，配置好ProxyFactoryBean，给ProxyFactoryBean设置一个bean id
        //然后通过ac.getBean(bean id),就取得被ProxyFactoryBean代理的对象，不是ProxyFactoryBean
        //因为这个bean id虽然代表ProxyFactoryBean对象，直接getBean获取的是ProxyFactoryBean.getObject()返回的对象，即代理对象
        //ac.getBean(&bean id),才能取得ProxyFactoryBean对象

        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setBeanFactory(ac.getBeanFactory());
        //aop拦截处理类
        proxyFactoryBean.setInterceptorNames("myBeforeAop");
        //代理的接口
        proxyFactoryBean.setInterfaces(ServiceInter.class);
        //被代理对象
        proxyFactoryBean.setTarget(ac.getBean(ServiceInter.class));
        //放入bean工厂，实际开发是在config下使用注解，设置多个proxyFactoryBean代理，设置不同bean id
        ac.getBeanFactory().registerSingleton("myproxy", proxyFactoryBean);

        ServiceInter servInterProxy = (ServiceInter) ac.getBean("myproxy");
        System.out.println("isAopProxy:" + AopUtils.isAopProxy(servInterProxy));
        System.out.println("getTargetClass:" + SpringProxyUtils.getTargetClass(servInterProxy));
        Class myServiceClass = SpringProxyUtils.getTargetClass(servInterProxy);
        ((ServiceInter)myServiceClass.newInstance()).say("你好");
        servInterProxy.say("哈哈");
        //获取直接的ProxyFactoryBean对象，加&
        System.out.println(ac.getBean("&myproxy"));
    }
}
