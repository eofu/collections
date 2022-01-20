package com.myself.pattern.creational.creational1factory.factory3abstractFactory.furniture.jingdong;

import com.myself.pattern.creational.creational1factory.factory1simplefactory.Furniture;
import com.myself.pattern.creational.creational1factory.factory3abstractFactory.furniture.AbstractFactory;

public class JingDongFactory extends AbstractFactory {
    @Override
    public Furniture getChair() {
        return new JingDongChair();
    }
    
    @Override
    public Furniture getDesk() {
        return new JingDongDesk();
    }
    
    @Override
    public Furniture getSofa() {
        return new JingDongSofa();
    }
}
