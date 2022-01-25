package com.myself.test;

public class Test7 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            double random = Math.random();
            double v = random * 9;
            double v1 = v + 1;
            double v2 = v1 * 100000;
            System.out.println(random + ":" + v + ":" + v1 + ":" + v2);
        }
    }
}
