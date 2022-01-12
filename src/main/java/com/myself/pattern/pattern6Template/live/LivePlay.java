package com.myself.pattern.pattern6Template.live;

public abstract class LivePlay {
    public final void seeLivePlay() {
        login();
        openRoom();
        startAudioAndVideoStream();
        pushVideoStream();
        stopAudioAndVideoStream();
        closeRoom();
    }
    
    // 实体方法，这个方法实现通用的业务逻辑
    public void login() {
        System.out.println("登录");
    }
    
    // 抽象方法
    public abstract void openRoom();
    
    // 抽象方法
    public abstract void startAudioAndVideoStream();
    
    // 钩子方法，可以被需要的子类overwrite
    public void pushVideoStream() {
    }
    
    // 抽象方法
    public abstract void stopAudioAndVideoStream();
    
    // 抽象方法
    public abstract void closeRoom();
}
