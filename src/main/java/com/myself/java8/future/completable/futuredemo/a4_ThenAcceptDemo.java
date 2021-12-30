package com.myself.java8.future.completable.futuredemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * 第一个任务执行完成后，执行第二个回调方法任务，会将该任务的执行结果，作为入参，传递到回调方法中，但是回调方法是没有返回值的。
 */
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
