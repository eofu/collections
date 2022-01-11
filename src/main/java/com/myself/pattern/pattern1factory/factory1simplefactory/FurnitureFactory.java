package com.myself.pattern.pattern1factory.factory1simplefactory;

public class FurnitureFactory {
    public Furniture getFurniture(String furniture) {
        if ("sofa".equals(furniture)) {
            return new Sofa();
        } else if ("chair".equals(furniture)) {
            return new Chair();
        } else if ("desk".equals(furniture)) {
            return new Desk();
        }
        return null;
    }
}
