package com.myself.pattern.behavioral.behavioral4observer.slackoff;

public class Client {
    public static void main(String[] args) {
        Secretary secretary = new Secretary();
    
        StockObserver observer = new StockObserver("adam", secretary);
    
        secretary.attach(observer);
    
        // secretary.delete(observer);
        
        secretary.setAction("Coming!");
        
        secretary.notifyObservers();
    }
}
