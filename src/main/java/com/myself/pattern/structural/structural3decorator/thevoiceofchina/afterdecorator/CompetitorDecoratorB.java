package com.myself.pattern.structural.structural3decorator.thevoiceofchina.afterdecorator;

import com.myself.pattern.structural.structural3decorator.thevoiceofchina.Competitor;

public class CompetitorDecoratorB extends CompetitorDecorator {
    
    public CompetitorDecoratorB(Competitor competitor) {
        super(competitor);
    }
    
    @Override
    public void sing() {
        this.playMusic();
        super.sing();
    }
    
    private void playMusic() {
        System.out.println("播放背景音乐～～～");
    }
    
}
