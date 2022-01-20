package com.myself.pattern.structural.structural2adapter.objectadapter;

import com.myself.pattern.structural.structural2adapter.classadapter.Adaptee;
import com.myself.pattern.structural.structural2adapter.classadapter.Target;

// 对象适配器
public class Adapter implements Target {
    private final Adaptee adaptee = new Adaptee();
    
    @Override
    public void request() {
        adaptee.adapteeRequest();
    }
}
