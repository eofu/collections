package com.myself.pattern.creational.creational1factory.factory1simplefactory;

/**
 * 1、你不想直接new这个类的对象，怕以后这个类改变的时候你需要回来改代码，而此时依赖这个类的地方已经到处都是了。
 * 2、这个类的对象构建过程非常复杂，你不愿意将这么复杂的构建过程一遍又一遍的写在需要用到此对象的地方。
 * 3、这个类的对象在构建过程中依赖了很多其他的类，而你无法在调用的地方提供。
 */
public class FurnitureTest {
    public static void main(String[] args) {
        FurnitureFactory furnitureFactory = new FurnitureFactory();
        System.out.println(furnitureFactory.getFurniture("chair"));
    }
}
