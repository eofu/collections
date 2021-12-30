package com.myself.java8.future.completable.futuredemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * 某个任务执行完成后，执行的回调方法，无返回值；并且whenComplete方法返回的CompletableFuture的result是上个任务的结果。
 */
public class a7_WhenCompleteDemo {
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

        CompletableFuture<String> then = firstFuture.whenComplete((a, throwable) -> {
            System.out.println("current thread name :" + Thread.currentThread().getName());
            System.out.println("last task return is " + a);
            if ("hello world".equals(a)) {
                System.out.println(a);
            }
            System.out.println("whencomplete");
        });

        System.out.println(then.get());
    }
}
