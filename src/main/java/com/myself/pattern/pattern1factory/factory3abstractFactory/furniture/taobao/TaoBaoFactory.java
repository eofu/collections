package com.myself.pattern.pattern1factory.factory3abstractFactory.furniture.taobao;

import com.myself.pattern.pattern1factory.factory1simplefactory.Furniture;
import com.myself.pattern.pattern1factory.factory3abstractFactory.furniture.AbstractFactory;

public class TaoBaoFactory extends AbstractFactory {
    @Override
    public Furniture getChair() {
        return new TaoBaoChair();
    }
    
    @Override
    public Furniture getDesk() {
        return new TaobaoDesk();
    }
    
    @Override
    public Furniture getSofa() {
        return new TaoBaoSofa();
    }
}
