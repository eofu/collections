package com.myself.java8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P01_Stream {
    List<String> list = Arrays.asList("张三", "李四", "王五", "xuwujing");
    
    public static void main(String[] args) {
        P01_Stream stream = new P01_Stream();
        stream.maxMinDistinct();
    }
    
    public void maxMinDistinct() {
        List<String> list13 = Arrays.asList("zhangsan", "lisi", "wangwu", "xuwujing");
        int maxLines = list13.stream().mapToInt(String::length).max().getAsInt();
        int minLines = list13.stream().mapToInt(String::length).min().getAsInt();
        System.out.println("最长字符的长度:" + maxLines + ",最短字符的长度:" + minLines);
        
        String lines = "good good study day day up";
        List<String> list14 = new ArrayList<String>();
        list14.add(lines);
        List<String> words = list14.stream().flatMap(line -> Stream.of(line.split(" "))).filter(word -> word.length() > 0).map(String::toLowerCase).distinct().sorted().collect(Collectors.toList());
        System.out.println("去重复之后:" + words);
    }
    
    /**
     * parallelStream 是流并行处理程序的代替方法。
     */
    public void parallel() {
        List<String> strings = Arrays.asList("a", "", "c", "", "e", "", " ");
        // 获取空字符串的数量
        long count = strings.parallelStream().filter(String::isEmpty).count();
        System.out.println("空字符串的个数:" + count);
    }
    
    /**
     * peek 对每个元素执行操作并返回一个新的 Stream
     * 双重操作
     */
    public void peek() {
        Stream.of("one", "two", "three", "four").peek(e -> System.out.println("转换之前: " + e)).map(String::toUpperCase).peek(e -> System.out.println("转换之后: " + e)).collect(Collectors.toList());
    }
    
    /**
     * sorted 方法用于对流进行升序排序。
     */
    public void sort1() {
        Random rd2 = new Random();
        System.out.println("取到的前三条数据然后进行排序:");
        rd2.ints().limit(3).sorted().forEach(System.out::println);
    }
    
    /**
     * 优化排序
     */
    public void sort2() {
        List<String> list = Arrays.asList("1", "6", "3", "9", "2", "89");
        List<String> list1 = list.stream().sorted(Comparator.naturalOrder()).limit(3).collect(Collectors.toList());
        System.out.println(list1);
        
        // //普通的排序取值
        // List<User> list11 = list9.stream().sorted((u1, u2) -> u1.getName().compareTo(u2.getName())).limit(3).collect(Collectors.toList());
        // System.out.println("排序之后的数据:" + list11);
        // //优化排序取值
        // List<User> list12 = list9.stream().limit(3).sorted((u1, u2) -> u1.getName().compareTo(u2.getName())).collect(Collectors.toList());
        // System.out.println("优化排序之后的数据:" + list12);
        
        //排序之后的数据:\[{"id":1,"name":"pancm1"}, {"id":2,"name":"pancm2"}, {"id":3,"name":"pancm3"}\]
        //优化排序之后的数据:\[{"id":1,"name":"pancm1"}, {"id":2,"name":"pancm2"}, {"id":3,"name":"pancm3"}\]
    }
    
    /**
     * limit 方法用于获取指定数量的流
     */
    public void limit1() {
        Random rd = new Random();
        System.out.println("取到的前三条数据:");
        rd.ints().limit(3).forEach(System.out::println);
    }
    
    /**
     * 结合 skip 使用得到需要的数据
     */
    public void limit2() {
        // List<User> list9 = new ArrayList<User>();
        //
        // for (int i = 1; i < 4; i++) {
        //     User user = new User(i, "pancm" + i);
        //     list9.add(user);
        // }
        // System.out.println("截取之前的数据:");
        // // 取前3条数据，但是扔掉了前面的2条，可以理解为拿到的数据为 2<=i<3 (i 是数值下标)
        // List<String> list10 = list9.stream().map(User::getName).limit(3).skip(2).collect(Collectors.toList());
        // System.out.println("截取之后的数据:" + list10);
    }
    
    /**
     * flatMap 方法用于映射每个元素到对应的结果，一对多。
     */
    public void flatMap() {
        String worlds = "The way of the future";
        List<String> list7 = new ArrayList<>();
        list7.add(worlds);
        List<String> list8 = list7.stream().flatMap(str -> Stream.of(str.split(" "))).filter(world -> world.length() > 0).collect(Collectors.toList());
        System.out.println("单词:");
        list8.forEach(System.out::println);
    }
    
    public void filter1() {
        List<String> stringList = list.stream().filter(str -> !"李四".equals(str)).collect(Collectors.toList());
        System.out.println(stringList);
    }
    
    /**
     * 通过与 findAny 得到 if/else 的值
     */
    public void filter2() {
        String result3 = list.stream().filter(str -> "李四".equals(str)).findAny().orElse("找不到!");
        String result4 = list.stream().filter(str -> "李二".equals(str)).findAny().orElse("找不到!");
        
        System.out.println(result3);
        System.out.println(result4);
    }
    
    /**
     * 通过与 mapToInt 计算和
     */
    public void filter3() {
        // int sum = lists.stream().filter(u -> "张三".equals(u.getName())).mapToInt(u -> u.getId()).sum();
        // System.out.println("计算结果:" + sum);
    }
    
    /**
     * map 方法用于映射每个元素到对应的结果，一对一
     */
    public void map() {
    
    }
    
    public void buildStream() {
        Stream stream = Stream.of("a", "b", "c");
        String[] strArray = new String[]{"a", "b", "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();
    }
}
