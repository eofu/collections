package com.myself.pattern.behavioral.behavioral4observer.observer;

/**
 * 具体主题
 */
public class ConcreteSubject extends Subject {
    // 具体业务
    public void doSomething() {
        super.notifyObservers();
    }
}
