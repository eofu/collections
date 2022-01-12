package com.myself.pattern.pattern5strategy.traficselect;


public class TrafficFeeCalculator {
    public int goToTianJinEye(CalculateStrategy strategy, int distance) {
        return strategy.calculateTrafficFee(distance);
    }
}