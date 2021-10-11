package com.myself.pattern.pattern3prototype;

import java.io.Serializable;

/**
 * 原型模式
 * 实现Cloneable接口，重写clone方法，实现深拷贝。
 * 还可以循环，反射
 */
public class Police implements Serializable, Cloneable {
    int age;
    String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
