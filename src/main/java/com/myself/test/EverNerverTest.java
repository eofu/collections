package com.myself.test;

import java.util.concurrent.ConcurrentSkipListMap;

public class EverNerverTest {
    public static void main(String[] args) {
        String s = "1";

        if (s == null) {
            assert false;
            System.out.println("2");
        }
        System.out.println(3);


        ConcurrentSkipListMap<Integer, String> skipListMap = new ConcurrentSkipListMap<>();
        skipListMap.put(1, "1");
    }
}
