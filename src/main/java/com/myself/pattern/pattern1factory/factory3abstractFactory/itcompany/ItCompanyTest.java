package com.myself.pattern.pattern1factory.factory3abstractFactory.itcompany;

import com.myself.pattern.pattern1factory.factory3abstractFactory.itcompany.apple.AppleFactory;
import com.myself.pattern.pattern1factory.factory3abstractFactory.itcompany.xiaomi.XiaoMiFactory;

public class ItCompanyTest {
    public static void main(String[] args) {
        AppleFactory appleFactory = new AppleFactory();
        appleFactory.makeComputer().setOperationSystem();
    
        XiaoMiFactory xiaoMiFactory = new XiaoMiFactory();
        xiaoMiFactory.makePhone().setOperationSystem();
    }
}
