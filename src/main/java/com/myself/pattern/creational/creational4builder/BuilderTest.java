package com.myself.pattern.creational.creational4builder;

public class BuilderTest {
    public static void main(String[] args) {
        Computer.Builder builder = new Computer.Builder("I9", "16g");
        Computer computer = builder.setDisplay("disPlay").setKeyboard("keyBoard").setUsbCount(8).build();
        System.out.println(computer);
    }
}
