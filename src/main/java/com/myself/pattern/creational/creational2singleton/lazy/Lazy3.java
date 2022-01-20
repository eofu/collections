package com.myself.pattern.creational.creational2singleton.lazy;

public class Lazy3 {
    // 使用时，会先初始化内部类

    private static Lazy3 getInstance() {
        return lazy3Holder.LAZY_3;
    }

    private static class lazy3Holder {
        private static final Lazy3 LAZY_3 = new Lazy3();
    }
}
