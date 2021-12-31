package com.myself.java8.future.completable.futuredemo;

import java.util.concurrent.*;

/**
 * applyToEither / acceptEither / runAfterEither 都表示：将两个CompletableFuture组合起来，只要其中一个执行完了,就会执行某个任务。<br>
 * <p>
 * 区别在于：<br>
 * applyToEither：会将已经执行完成的任务，作为方法入参，传递到指定方法中，且有返回值<br>
 * acceptEither: 会将已经执行完成的任务，作为方法入参，传递到指定方法中，且无返回值<br>
 * runAfterEither：不会把执行结果当做方法入参，且没有返回值。<br>
 */
public class a10_ToEitherDemo {
    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
        // 第一个异步任务，休眠2秒，保证它执行晚点
        CompletableFuture<String> firstFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000L);
                System.out.println("completed the first one Asyn task!");
            } catch (InterruptedException e) {
                return "the first task exception!";
            }
            return "the first";
        });
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<Void> eitherAsync = CompletableFuture
                // 第二个异步任务
                .supplyAsync(() -> {
                    System.out.println("completed the second task");
                    return "the second";
                }, executor)
                // 第三个任务
                .acceptEitherAsync(firstFuture, System.out::println, executor);

        executor.shutdown();
    }
}
