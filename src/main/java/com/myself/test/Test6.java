package com.myself.test;

import java.util.function.Supplier;

public class Test6 {
    public static void main(String[] args) {
        String string = getString(() -> {
            return "派大星";
        });

        String string1 = getString(() -> "海绵宝宝");
    }

    public static String getString(Supplier<String> sup) {
        return sup.get();
    }
}
