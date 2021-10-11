package com.myself.pattern.pattern1factory;

import com.myself.pattern.pattern1factory.Factory;
import com.myself.pattern.pattern1factory.simple.Furniture;
import com.myself.pattern.pattern1factory.simple.Sofa;

public class SofaFactory implements Factory {
    @Override
    public Furniture getfurniture() {
        return new Sofa();
    }
}
