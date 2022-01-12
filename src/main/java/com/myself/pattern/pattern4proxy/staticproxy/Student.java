package com.myself.pattern.pattern4proxy.staticproxy;

public class Student extends Person {
    @Override
    public void buyTicket() {
        System.out.println("student buy ticket");
    }
}
