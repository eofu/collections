package com.myself.pattern.structural.structural1proxy.dynamicproxy.cglib.example02;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

public class CglibDynProxyLawyer implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if ("submit".equals(method.getName())) {
            System.out.println("拦截成功！" + Arrays.asList(objects));
        }
        
        return methodProxy.invokeSuper(o, objects);
    }
}
