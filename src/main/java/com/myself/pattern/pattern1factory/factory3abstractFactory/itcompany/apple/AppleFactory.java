package com.myself.pattern.pattern1factory.factory3abstractFactory.itcompany.apple;

import com.myself.pattern.pattern1factory.factory3abstractFactory.itcompany.AbstractFactory;
import com.myself.pattern.pattern1factory.factory3abstractFactory.itcompany.Computer;
import com.myself.pattern.pattern1factory.factory3abstractFactory.itcompany.Phone;

public class AppleFactory implements AbstractFactory {
    @Override
    public Computer makeComputer() {
        return new MacBook();
    }
    
    @Override
    public Phone makePhone() {
        return new Iphone();
    }
}
