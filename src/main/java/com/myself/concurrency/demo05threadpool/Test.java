package com.myself.concurrency.demo05threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutor：
 * <br>corePoolSize：核心线程数。
 * <br>maximumPoolSize：池中允许的最大线程数。核心线程数+临时线程数
 * <br>keepAliveTime：线程空闲超时时间。非核心线程超时回收，allowCoreThreadTimeOut为true时，核心线程超时回收。
 * <br>unit：时间单位。
 * <br>workQueue：任务队列。核心线程全部繁忙时，后续executor方法提交的Runnable将存放在任务队列中。
 * <br>threadFactory：线程工厂。指定线程池创建线程的的方式。
 * <br>handler：拒绝策略。线程数最大，任务队列已满时，指定拒绝方式
 */
public class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3, 5, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
        for (int i = 0; i < threadPool.getCorePoolSize(); i++) {
            threadPool.execute(() -> {
                for (int x = 0; x < 2; x++) {
                    System.out.println(Thread.currentThread().getName() + ":" + x);
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        threadPool.shutdown();
    }
}
