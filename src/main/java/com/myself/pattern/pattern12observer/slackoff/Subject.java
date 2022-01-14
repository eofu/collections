package com.myself.pattern.pattern12observer.slackoff;

/**
 * 通知者
 */
public interface Subject {
    void attach(Observer observer);
    
    void delete(Observer observer);
    
    void notifyObservers();
    
    String getAction();
    
    void setAction(String action);
}
