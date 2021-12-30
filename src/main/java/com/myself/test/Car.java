package com.myself.test;

import lombok.Data;

@Data
public class Car {
    private String name;
    private Double length;
    private Double width;
    private int age;

    public Car(String name, Double length, Double width, int age) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.age = age;
    }
}
