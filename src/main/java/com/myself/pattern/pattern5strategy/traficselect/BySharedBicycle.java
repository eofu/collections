package com.myself.pattern.pattern5strategy.traficselect;

public class BySharedBicycle implements CalculateStrategy {
    @Override
    public int calculateTrafficFee(int distance) {
        return 2;
    }
}
