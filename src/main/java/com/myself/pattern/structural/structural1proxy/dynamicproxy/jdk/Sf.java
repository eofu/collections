package com.myself.pattern.structural.structural1proxy.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Sf implements InvocationHandler {
    
    private Person person;
    
    public Object getInstance(Person person) {
        this.person = person;
        return Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                this
        );
    }
    
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("顺丰上门");
        method.invoke(this.person, args);
        System.out.println("到付180");
        return null;
    }
}
