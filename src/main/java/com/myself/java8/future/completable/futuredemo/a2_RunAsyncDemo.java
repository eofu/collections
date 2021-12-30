package com.myself.java8.future.completable.futuredemo;

import java.util.concurrent.*;

public class a2_RunAsyncDemo {
    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
        // 自定义线程池
        ExecutorService executor = Executors.newCachedThreadPool();
        // runAsync的使用
        CompletableFuture<Void> runFuture = CompletableFuture.runAsync(() -> System.out.println("runnable"), executor);
        // supplyAsync的使用
        CompletableFuture<String> supplyFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("callable");
            return "callable_return";
        }, executor);
        System.out.println("runFuture.join()" + runFuture.join());
        System.out.println("supplyFuture.join()" + supplyFuture.join());
        executor.shutdown();
    }
}
