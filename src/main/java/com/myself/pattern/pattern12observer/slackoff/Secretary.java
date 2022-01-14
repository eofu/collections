package com.myself.pattern.pattern12observer.slackoff;

import java.util.LinkedList;
import java.util.List;

public class Secretary implements Subject {
    private final List<Observer> observers = new LinkedList();
    private String action;
    
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }
    
    @Override
    public void delete(Observer observer) {
        observers.remove(observer);
    }
    
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
    
    @Override
    public String getAction() {
        return action;
    }
    
    @Override
    public void setAction(String action) {
        this.action = action;
    }
}
