package com.myself.juc.m_000;

import java.util.concurrent.*;

public class M05_FutureTask {

    private static final ExecutorService pool = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        FutureTask<Integer> futureTask = new FutureTask<>(myTask);
        pool.submit(futureTask);
        Integer result1 = null;
        Integer result2 = null;
        try {
            result1 = futureTask.get();
            result2 = futureTask.get(4, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println(result1);
        System.out.println(result2);
    }

    static class MyTask implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for (int i = 0; i < 1000; i++) {
                sum += i;
            }
            TimeUnit.SECONDS.sleep(1);
            return sum;
        }
    }
}
