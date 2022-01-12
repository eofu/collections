package com.myself.pattern.pattern9decorator.coffee;

/**
 * 原始对象
 */
public class OriginalCoffee implements ICoffee {
    
    @Override
    public void makeCoffee() {
        System.out.println("原味咖啡");
    }
}
