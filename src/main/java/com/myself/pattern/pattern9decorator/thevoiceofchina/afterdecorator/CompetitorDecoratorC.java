package com.myself.pattern.pattern9decorator.thevoiceofchina.afterdecorator;

import com.myself.pattern.pattern9decorator.thevoiceofchina.Competitor;

public class CompetitorDecoratorC extends CompetitorDecorator {
    
    public CompetitorDecoratorC(Competitor competitor) {
        super(competitor);
    }
    
    @Override
    public void sing() {
        this.introduceBGrd();
        super.sing();
    }
    
    private void introduceBGrd() {
        System.out.println("悲惨世界～～～");
    }
    
}
