package com.myself.pattern.pattern9decorator.coffee;

public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(ICoffee iCoffee) {
        super(iCoffee);
    }
    
    @Override
    public void makeCoffee() {
        super.makeCoffee();
        addSugar();
    }
    
    private void addSugar() {
        System.out.println("加糖");
    }
}
