package com.myself.pattern.pattern11bridgging.coffeemaker;

/**
 * 抽象化部分
 */
public abstract class Coffee {
    protected ICoffeeAdditives additives;
    
    public Coffee(ICoffeeAdditives additives) {
        this.additives = additives;
    }
    
    /**
     * 咖啡容量的维度
     */
    public abstract void orderCoffee(int count);
}
