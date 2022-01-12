package com.myself.pattern.pattern6Template.live;

/**
 * 主要是提高了代码的复用度，而且很好的符合的“开闭原则”。
 * 设计模式的通病：类增多了
 * 调用控制反转：一般情况下，程序的执行流是子类调用父类的方法，模板方法模式使得程序流程变成了父类调用子类方法，这个使得程序比较难以理解和跟踪。
 */
public class LiveTest {
    public static void main(String[] args) {
        TencentLivePlay tencentLivePlay = new TencentLivePlay();
        tencentLivePlay.seeLivePlay();
        
        System.out.println();
        
        JinShanLivePlay jinShanLivePlay = new JinShanLivePlay();
        jinShanLivePlay.seeLivePlay();
    }
}
