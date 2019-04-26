package com.lcl.proxy;

/**
 * @author liuchunli3
 * @date 2019/4/25 16:54
 */
public class ZhangSan implements IPerson {
    public String say(String msg) {
        String ret = "张三说:"+msg;
        System.out.println(ret);
        return ret;
    }

    public String eat(String food) {
        String ret = "张三吃:"+food;
        System.out.println(ret);
        return ret;
    }
}
