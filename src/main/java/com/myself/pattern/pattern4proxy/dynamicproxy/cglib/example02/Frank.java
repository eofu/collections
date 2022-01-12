package com.myself.pattern.pattern4proxy.dynamicproxy.cglib.example02;

public class Frank {
    public void submit(String proof) {
        System.out.printf("老板欠薪跑路，证据如下：%s%n", proof);
    }
    
    public void defend() {
        System.out.printf("铁证如山，%s还Frank血汗钱%n", "张三");
    }
}
