package com.myself.pattern.pattern1factory.abstractFactory;

import com.myself.pattern.pattern1factory.abstractFactory.AbstractFurnitureFactory;

public class AbstractFurnitureTest {
    public static void main(String[] args) {
        AbstractFurnitureFactory abstractFurnitureFactory = new AbstractFurnitureFactory();
        System.out.println(abstractFurnitureFactory.getChair());
    }
}
