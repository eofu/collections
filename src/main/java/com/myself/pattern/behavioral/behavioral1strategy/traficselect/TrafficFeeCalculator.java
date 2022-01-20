package com.myself.pattern.behavioral.behavioral1strategy.traficselect;


public class TrafficFeeCalculator {
    public int goToTianJinEye(CalculateStrategy strategy, int distance) {
        return strategy.calculateTrafficFee(distance);
    }
}