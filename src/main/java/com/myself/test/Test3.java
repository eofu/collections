package com.myself.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test3 {
    public static void main(String[] args) {
        Map<Object, Object> objectObjectHashMap = new HashMap<>();

        List<Object> objects = new ArrayList<>();
        objects.add("1");
        objects.add("1");
        objects.add("2");
        objects.add("2");
        objects.add("4");

        for (Object object : objects) {
            System.out.println("object:" + object);
            Object put = objectObjectHashMap.put( object, object);
            System.out.println(put);
        }
    }
}
