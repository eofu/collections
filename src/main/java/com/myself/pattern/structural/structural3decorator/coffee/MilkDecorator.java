package com.myself.pattern.structural.structural3decorator.coffee;

public class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(ICoffee iCoffee) {
        super(iCoffee);
    }
    
    @Override
    public void makeCoffee() {
        super.makeCoffee();
        addMilk();
    }
    
    private void addMilk() {
        System.out.println("加奶");
    }
}
