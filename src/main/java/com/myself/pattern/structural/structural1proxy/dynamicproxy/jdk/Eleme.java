package com.myself.pattern.structural.structural1proxy.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


// 每一个动态代理对象都会关联一个InvocationHandler对象，当代理对象的任何方法被调用的时候，都会被转发到InvocationHandler对象的invoke()方法上去。Ò
// JDK的动态代理是靠多态和反射来实现的，
// 它生成的代理类需要实现你传入的接口，并通过反射来得到接口的方法对象，
// 并将此方法对象传参给增强类的invoke方法去执行，
// 从而实现了代理功能，故接口是jdk动态代理的核心实现方式，没有它就无法通过反射找到方法，所以这也是必须有接口的原因。
public class Eleme implements InvocationHandler {
    private Person person;
    
    /**
     * 动态代理的一般模式是会在代理对象上执行被代理的操作，然后使用Method.invoke()方法将请求转发给被代理对象处理，并传入必须的参数。这样看起来作用并不是很大，但实际使用的时候是可以对传入的参数进行处理的并且还可以根据Method中获取的信息来决定如何对方法进行转发，处理过程是可以非常灵活的。
     *
     * @param proxy  代理对象
     * @param method 代理对象中需被代理的方法
     * @param args   调用这个方法所传入的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 做代理逻辑
        System.out.println("代理................");
        // person.shopping();
        return method.invoke(person, args);
    }
    
    
    public Object getInstance(Person person) {
        this.person = person;
        Class<? extends Person> aClass = person.getClass();
        
        // 返回代理后的对象
        return Proxy.newProxyInstance(
                // 指定产生代理对象的类加载器
                aClass.getClassLoader(),
                // 指定目标对象的实现接口
                aClass.getInterfaces(),
                // 指定InvocationHandler对象
                this
        );
    }
}
