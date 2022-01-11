package com.myself.test;

import java.util.Calendar;
import java.util.Date;
import java.util.function.Supplier;

public class Test6 {
    public static void main(String[] args) {
        Calendar instance1 = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance1.setTime(new Date(1641458032550L));
        instance2.setTime(new Date());
        System.out.println(instance1.before(instance2));
    }

    public static String getString(Supplier<String> sup) {
        return sup.get();
    }
}
