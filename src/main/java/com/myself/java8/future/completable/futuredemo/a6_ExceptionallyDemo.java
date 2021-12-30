package com.myself.java8.future.completable.futuredemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class a6_ExceptionallyDemo {
    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
        CompletableFuture<String> firstFuture = CompletableFuture.supplyAsync(
                () -> {
                    System.out.println("the first one task!" + Thread.currentThread().getName());
                    throw new RuntimeException();
                }
        );

        CompletableFuture<String> then = firstFuture.exceptionally((e) -> {
            e.printStackTrace();
            return "u r b exception!";
        });

        System.out.println(then.get());
    }
}
