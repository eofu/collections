package com.myself.pattern.behavioral.behavioral1strategy.traficselect;

public class BySharedBicycle implements CalculateStrategy {
    @Override
    public int calculateTrafficFee(int distance) {
        return 2;
    }
}
