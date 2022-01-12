package com.myself.pattern.pattern6Template.live;

public class TencentLivePlay extends LivePlay{
    @Override
    public void openRoom() {
    
    }
    
    @Override
    public void startAudioAndVideoStream() {
    
    }
    
    @Override
    public void stopAudioAndVideoStream() {
    
    }
    
    @Override
    public void closeRoom() {
    
    }
    
    @Override
    public void pushVideoStream() {
        super.pushVideoStream();
        System.out.println("腾讯上钩");
    }
}
