package com.myself.pattern.pattern12observer.slackoff;

/**
 * 具体观察者
 */
public class StockObserver extends Observer {
    public StockObserver(String name, Subject subject) {
        super(name, subject);
    }
    
    @Override
    public void update() {
        System.out.println(subject.getAction() + "\n" + name + "关闭手机，继续工作");
    }
}
