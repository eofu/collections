package com.myself.pattern.pattern4proxy.dynamicproxy.jdk;

import com.myself.pattern.pattern4proxy.dynamicproxy.jdk.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Programmer implements Person {

    public void shopping() {
        System.out.println("买电脑");
    }


    public void dinner() {
        System.out.println("吃泡面");
    }



}
