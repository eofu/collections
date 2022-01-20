package com.myself.pattern.structural.structural3decorator.coffee;

/**
 * 装饰着抽象基类
 */
public class CoffeeDecorator implements ICoffee{
    private ICoffee iCoffee;
    
    public CoffeeDecorator(ICoffee iCoffee) {
        this.iCoffee = iCoffee;
    }
    
    @Override
    public void makeCoffee() {
        iCoffee.makeCoffee();
    }
}
