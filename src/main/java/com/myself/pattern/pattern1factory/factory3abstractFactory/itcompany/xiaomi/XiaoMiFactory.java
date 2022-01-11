package com.myself.pattern.pattern1factory.factory3abstractFactory.itcompany.xiaomi;

import com.myself.pattern.pattern1factory.factory3abstractFactory.itcompany.AbstractFactory;
import com.myself.pattern.pattern1factory.factory3abstractFactory.itcompany.Computer;
import com.myself.pattern.pattern1factory.factory3abstractFactory.itcompany.Phone;

public class XiaoMiFactory  implements AbstractFactory {
    @Override
    public Computer makeComputer() {
        return new MiComputer();
    }
    
    @Override
    public Phone makePhone() {
        return new MiPhone();
    }
}
