package com.myself.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        List<Person> objects = new ArrayList<>();
        objects.add(new Person("1", 11));
        objects.add(new Person("1", 22));
        objects.add(new Person("3", 33));
        objects.add(new Person("4", 44));

        Map<String, Integer> collect = objects.stream().collect(Collectors.toMap(Person::getName, Person::getAge, (value1, value2) -> value2));
        for (Map.Entry<String, Integer> stringIntegerEntry : collect.entrySet()) {
            System.out.println(stringIntegerEntry);
        }
        Integer integer = collect.get("1");
        System.out.println(integer);
    }

    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
