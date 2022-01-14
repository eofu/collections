package com.myself.pattern.pattern7delegate.leader;

public class Boss {
    public static void main(String[] args) {
        // 委派模式是静态代理模式和策略模式的特殊组合
        // 委派者持有被委派者的引用
        // 委派模式注重结果，代理模式注重的是过程
        // 策略模式注重的是可扩展（外部扩展），委派模式注重的内部的灵活和复用
        Leader leader = new Leader();
        leader.doing("加密");
        leader.doing("登陆");
    }
}
