package com.myself.pattern.pattern1factory.simple;

import com.myself.pattern.pattern1factory.simple.Chair;
import com.myself.pattern.pattern1factory.simple.Desk;
import com.myself.pattern.pattern1factory.simple.Furniture;
import com.myself.pattern.pattern1factory.simple.Sofa;

public class FurnitureFactory {
    public Furniture getFurniture(String furniture) {
        if ("sofa".equals(furniture)) {
            return new Sofa();
        }else if("chair".equals(furniture)){
            return new Chair();
        }else if("desk".equals(furniture)){
            return new Desk();
        }
        return null;
    }
}
