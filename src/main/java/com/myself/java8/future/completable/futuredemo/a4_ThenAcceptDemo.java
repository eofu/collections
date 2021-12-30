package com.myself.java8.future.completable.futuredemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class a4_ThenAcceptDemo {
    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
        CompletableFuture<String> firstFuture = CompletableFuture.supplyAsync(
                () -> {
                    System.out.println("the first one task!");
                    return "hello world";
                }
        );

        CompletableFuture<Void> then = firstFuture.thenAccept((a) -> {
            if ("hello world".equals(a)) {
                System.out.println(a);
            } else {
                System.out.println("goodBye world");
            }
        });

        System.out.println(then.get());
    }
}
