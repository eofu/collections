package com.myself.pattern.pattern4proxy.dynamicproxy.cglib.example02;

import net.sf.cglib.proxy.Enhancer;

public class ProxyFactory {
    public static Object getCgLibDynProxy(Object object) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(new CglibDynProxyLawyer());
        return enhancer.create();
    }
}
