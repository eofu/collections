package com.myself.java8.future.completable.futuredemo;

import java.util.concurrent.*;

/**
 * thenCompose方法会在某个任务执行完成后，将该任务的执行结果,作为方法入参,去执行指定的方法。该方法会返回一个新的CompletableFuture实例<br>
 * <p>
 * 如果该CompletableFuture实例的result不为null，则返回一个基于该result新的CompletableFuture实例；<br>
 * 如果该CompletableFuture实例为null，然后就执行这个新任务<br>
 */
public class a13_ThenComposeDemo {
    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
        CompletableFuture<String> f = CompletableFuture.completedFuture("the first task");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> "the second task", executor)
                .thenComposeAsync(data -> {
                    System.out.println(data);
                    return f;
                }, executor);
        System.out.println(future.join());
        executor.shutdown();
    }
}
