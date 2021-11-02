package com.myself.juc.m_000;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class M03_FutureTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Calc task = new Calc();
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        executor.submit(futureTask);
        executor.shutdown();
    }

    public static class Calc implements Callable<Integer> {
        public static int cal(int num) {
            int sum = 0;
            for (int i = 0; i < num; i++) {
                sum += i;
            }
            return sum;
        }

        @Override
        public Integer call() throws Exception {
            return cal(100000000);
        }
    }
}
