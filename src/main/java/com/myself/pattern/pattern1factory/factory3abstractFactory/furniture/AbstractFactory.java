package com.myself.pattern.pattern1factory.factory3abstractFactory.furniture;

import com.myself.pattern.pattern1factory.factory1simplefactory.Furniture;

public abstract class AbstractFactory {
    public abstract Furniture getChair();
    public abstract Furniture getDesk();
    public abstract Furniture getSofa();
}
