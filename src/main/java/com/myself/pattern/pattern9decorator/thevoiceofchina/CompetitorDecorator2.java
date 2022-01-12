package com.myself.pattern.pattern9decorator.thevoiceofchina;

public class CompetitorDecorator2 extends Competitor {
    @Override
    public void sing() {
        this.playMusic();
        super.sing();
    }
    
    private void playMusic() {
        System.out.println("播放背景音乐......");
    }
}
