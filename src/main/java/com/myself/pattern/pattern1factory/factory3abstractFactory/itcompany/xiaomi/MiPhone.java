package com.myself.pattern.pattern1factory.factory3abstractFactory.itcompany.xiaomi;

import com.myself.pattern.pattern1factory.factory3abstractFactory.itcompany.Phone;

public class MiPhone extends Phone {
    @Override
    public void setOperationSystem() {
        System.out.println("Android");
    }
}
