package com.myself.pattern.structural.structural1proxy.dynamicproxy.cglib.example01;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class PaoTui implements MethodInterceptor {
    public Object getInstance(Class tClass) {
        Enhancer enhancer = new Enhancer();

        // 设置将生成类的父类
        enhancer.setSuperclass(tClass);
        // 用来调用的对象
        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 业务的增强
        System.out.println("跑腿接单");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("东西送达");
        return o1;
    }
}
