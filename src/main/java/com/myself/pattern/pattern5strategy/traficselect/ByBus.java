package com.myself.pattern.pattern5strategy.traficselect;

public class ByBus implements CalculateStrategy{
    @Override
    public int calculateTrafficFee(int distance) {
        return distance<10?4:6;
    }
}
