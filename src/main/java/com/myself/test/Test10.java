package com.myself.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test10 {
    public static void main(String[] args) {
        Test10 test10 = new Test10();
        test10.inner();
    }
    
    public void inner() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("普通方式创建");
            }
        };
        runnable.run();
        
        Runnable r2 = () -> System.out.println("created by lambda");
        r2.run();
    }
    
    public void list() {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("bb");
        list.add("ccc");
        list.add("dddd");
        
        list.forEach((v) -> {System.out.println(v);});
        list.forEach(System.out::println);
    }
    
    public void map() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        map.put("d", "d");
        
        map.forEach((k, v) -> {
            System.out.println("k=" + k + ",v=" + v);
        });
    }
    
}
