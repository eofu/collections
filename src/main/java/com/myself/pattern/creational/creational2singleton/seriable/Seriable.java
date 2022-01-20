package com.myself.pattern.creational.creational2singleton.seriable;

import java.io.Serializable;

/**
 * 序列化与反序列化
 */
public class Seriable implements Serializable {
    private static final Seriable SERIABLE = new Seriable();

    private Seriable() {

    }

    public Seriable getInstance() {
        return SERIABLE;
    }

    // 重新方法保障线程安全
    private Object readResolve() {
        return SERIABLE;
    }
}
