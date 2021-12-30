package com.myself.java8.future.completable.futuredemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class a3_ThenRunDemo {
    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
        CompletableFuture<String> firstFuture = CompletableFuture.supplyAsync(
                () -> {
                    System.out.println("the first one task!");
                    return "hello world";
                }
        );

        CompletableFuture<Void> thenRun = firstFuture.thenRun(() -> {
            System.out.println("the secend task!");
        });

        System.out.println(thenRun.get());
    }
}
