package com.myself.pattern.structural.structural2adapter.classadapter;

/**
 * 适配器LogAdapter 必须要实现目标接口，且依赖那个提供功能的类型，此处为NbLogger
 * 极大的增强了程序的可扩展性，通过此模式，你可以随意扩展程序的功能，但却不需要修改接口
 * 没啥缺点，唯一可以称的上的缺点是多了一层，但是这也是没有办法的事情。
 */
public class Test {
    public static void main(String[] args) {
        new ConcreteTarget().request();
        new Adaptee().adapteeRequest();
        new Adapter().request();
    }
}
