package com.myself.pattern.pattern8adapter.objectadapter;

import com.myself.pattern.pattern8adapter.classadapter.Adaptee;
import com.myself.pattern.pattern8adapter.classadapter.Target;

// 对象适配器
public class Adapter implements Target {
    private final Adaptee adaptee = new Adaptee();
    
    @Override
    public void request() {
        adaptee.adapteeRequest();
    }
}
