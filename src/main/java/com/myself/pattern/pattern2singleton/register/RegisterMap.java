package com.myself.pattern.pattern2singleton.register;

import java.util.HashMap;

/**
 * 注册登记式：将对象存入缓存
 * IOC中的单例模式就是登记注册式
 */
public class RegisterMap {
    private static final HashMap register = new HashMap<String, Object>();

    private RegisterMap() {

    }

    public static RegisterMap getInstance(String name) {
        if (name == null) {
            name = RegisterMap.class.getName();
        }

        if (register.get(name) == null) {
            register.put(name, new RegisterMap());
        }

        return (RegisterMap) register.get(name);
    }
}
