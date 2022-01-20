package com.myself.pattern.structural.structural1proxy.dynamicproxy.myjdkproxy;

import java.lang.reflect.Method;

public interface MyInvocationHandler {
    Object invoke(Object proxy, Method method, Object[] args) throws Exception;
}
