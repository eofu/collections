package com.myself.java8.future.completable.futuredemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class a5_ThenApplyDemo {
    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
        CompletableFuture<String> firstFuture = CompletableFuture.supplyAsync(
                () -> {
                    System.out.println("the first one task!");
                    return "hello world";
                }
        );

        CompletableFuture<String> then = firstFuture.thenApply((a) -> {
            if ("hello world".equals(a)) {
                return a;
            } else {
                return "goodBye world";
            }
        });

        System.out.println(then.get());
    }
}
