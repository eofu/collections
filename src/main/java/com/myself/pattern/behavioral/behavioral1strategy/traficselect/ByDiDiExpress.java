package com.myself.pattern.behavioral.behavioral1strategy.traficselect;

public class ByDiDiExpress implements CalculateStrategy{
    @Override
    public int calculateTrafficFee(int distance) {
        return distance<3?8:(8+(distance-3)*3);
    }
}
