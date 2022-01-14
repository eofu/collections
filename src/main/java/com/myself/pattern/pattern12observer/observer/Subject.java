package com.myself.pattern.pattern12observer.observer;

import java.util.Vector;

/**
 * 主题
 */
public class Subject {
    private final Vector<Observer> oVector = new Vector<>();
    
    public void addObserver(Observer observer) {
        this.oVector.add(observer);
    }
    
    public void deleteObserver(Observer observer) {
        this.oVector.remove(observer);
    }
    
    public void notifyObservers() {
        for (Observer observer : this.oVector) {
            observer.update();
        }
    }
}
