package com.myself.pattern.pattern8adapter.classadapter;

// 类适配器
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        super.adapteeRequest();
    }
}
