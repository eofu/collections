package com.myself.pattern.pattern1factory.factory3abstractFactory.itcompany.xiaomi;

import com.myself.pattern.pattern1factory.factory3abstractFactory.itcompany.Computer;

public class MiComputer extends Computer {
    @Override
    public void setOperationSystem() {
        System.out.println("Windows10");
    }
}
