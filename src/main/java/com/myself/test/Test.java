package com.myself.test;

import com.myself.utils.CopyBeanUtils;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car("car", 10.0, 20.0, 50);
        Tree tree = new Tree();
        CopyBeanUtils.copyProperties(car, tree);
        System.out.println(car);
        System.out.println(tree);
    }
}
