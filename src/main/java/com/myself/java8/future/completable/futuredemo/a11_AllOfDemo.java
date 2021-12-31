package com.myself.java8.future.completable.futuredemo;

import java.util.concurrent.*;

/**
 * 所有任务都执行完成后，才执行 allOf返回的CompletableFuture。如果任意一个任务异常，allOf的CompletableFuture，执行get方法，会抛出异常
 */
public class a11_AllOfDemo {
    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
        CompletableFuture<Void> a = CompletableFuture.runAsync(() -> {
            System.out.println("done!");
        });
        CompletableFuture<Void> b = CompletableFuture.runAsync(() -> {
            System.out.println("done Either!");
        });
        CompletableFuture<Void> allOfFuture = CompletableFuture.allOf(a, b).whenComplete((m,k)->{
            System.out.println("finish!");
        });
    }
}
