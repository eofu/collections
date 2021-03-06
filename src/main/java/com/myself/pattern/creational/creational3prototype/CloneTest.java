package com.myself.pattern.creational.creational3prototype;

public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        com.myself.pattern.creational.creational3prototype.Police police = new com.myself.pattern.creational.creational3prototype.Police();
        police.name = "police";
        police.age = 30;
        
        com.myself.pattern.creational.creational3prototype.Police clonePolice = (Police) police.clone();
        System.out.println(clonePolice.name + clonePolice.age);
        System.out.println(clonePolice == police);
    }
}
