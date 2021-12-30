package com.myself.java8.future.completable.futuredemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * 某个任务执行完成后，执行回调方法，并且是有返回值的;并且handle方法返回的CompletableFuture的result是回调方法执行的结果。
 */
public class a8_HandleDemo {
    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
        CompletableFuture<String> firstFuture = CompletableFuture.supplyAsync(
                () -> {
                    System.out.println("the first one task!" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "hello world";
                }
        );

        CompletableFuture<String> then = firstFuture.handle((a, throwable) -> {
            System.out.println("last task return is " + a);
            if ("hello world".equals(a)) {
                System.out.println(a);
                return "in if";
            }
            System.out.println("whencomplete");
            return null;
        });

        System.out.println(then.get());
    }
}
