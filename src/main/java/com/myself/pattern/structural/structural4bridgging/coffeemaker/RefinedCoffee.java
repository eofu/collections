package com.myself.pattern.structural.structural4bridgging.coffeemaker;

import java.util.Random;

/**
 * 抽象化的修正类
 */
public abstract class RefinedCoffee extends Coffee {
    public RefinedCoffee(ICoffeeAdditives additives) {
        super(additives);
    }
    
    /**
     * 品控
     */
    public void checkQuality() {
        Random random = new Random();
        System.out.printf("%s 添加%s", additives.getClass().getSimpleName(), random.nextBoolean() ? "太多" : "正常/n");
    }
}
