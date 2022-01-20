package com.myself.pattern.creational.creational1factory.factory3abstractFactory.itcompany.apple;

import com.myself.pattern.creational.creational1factory.factory3abstractFactory.itcompany.Computer;

public class MacBook extends Computer {
    @Override
    public void setOperationSystem() {
        System.out.println("MacOS");
    }
}
