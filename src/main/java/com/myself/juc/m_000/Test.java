package com.myself.juc.m_000;

public class Test {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Server server = new Server();
        Data_Future<String> dataFuture = server.getData();

        try {
            // 先执行其他操作
            Thread.sleep(1000);
            // 模拟耗时...
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("结果数据：" + dataFuture.getRealData());
        System.out.println("耗时: " + (System.currentTimeMillis() - start));
    }
}
