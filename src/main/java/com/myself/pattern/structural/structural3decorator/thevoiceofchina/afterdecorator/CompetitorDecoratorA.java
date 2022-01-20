package com.myself.pattern.structural.structural3decorator.thevoiceofchina.afterdecorator;

import com.myself.pattern.structural.structural3decorator.thevoiceofchina.Competitor;

public class CompetitorDecoratorA extends CompetitorDecorator {
    
    public CompetitorDecoratorA(Competitor competitor) {
        super(competitor);
    }
    
    @Override
    public void sing() {
        this.dance();
        super.sing();
    }
    
    private void dance() {
        System.out.println("伴舞上场～～～");
    }
    
}
