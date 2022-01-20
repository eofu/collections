package com.myself.pattern.creational.creational2singleton.lazy;

public class Lazy2 {
    private static final Lazy2 lazy1 = null;

    private Lazy2() {

    }

    private static synchronized Lazy2 getInstance() {
        if (lazy1 == null) {
            Lazy2 lazy1 = new Lazy2();
        }
        return lazy1;
    }

}
