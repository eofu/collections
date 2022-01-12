package com.myself.pattern.pattern4proxy.dynamicproxy.jdk;

public class Programmer implements Person {
    
    @Override
    public void shopping() {
        System.out.println("买电脑");
    }
    
    
    @Override
    public void dinner() {
        System.out.println("吃泡面");
    }
    
    
}
