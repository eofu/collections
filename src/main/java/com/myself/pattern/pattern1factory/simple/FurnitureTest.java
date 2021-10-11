package com.myself.pattern.pattern1factory.simple;

import com.myself.pattern.pattern1factory.simple.FurnitureFactory;

public class FurnitureTest {
    public static void main(String[] args) {
        FurnitureFactory furnitureFactory = new FurnitureFactory();
        System.out.println(furnitureFactory.getFurniture("chair"));
    }
}
