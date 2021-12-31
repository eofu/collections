package com.myself.java8.future.completable.futuredemo;

import com.myself.java8.future.completable.entity.MedalInfo;
import com.myself.java8.future.completable.service.MedalService;
import com.myself.java8.future.completable.entity.UserInfo;
import com.myself.java8.future.completable.service.UserInfoService;
import com.myself.utils.SnowFlakeIdWorker;

import java.util.concurrent.*;

public class a01_SupplyAsyncDemo {
    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
        UserInfoService userInfoService = new UserInfoService();
        MedalService medalService = new MedalService();
        Long userId = SnowFlakeIdWorker.generateId();
        long startTime = System.currentTimeMillis();

        CompletableFuture<UserInfo> completableUserInfoFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return userInfoService.getUserInfo(userId);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        });

        Thread.sleep(300);

        CompletableFuture<MedalInfo> completableMedalFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return medalService.getMedalInfo(userId);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        });

        UserInfo userInfo = completableUserInfoFuture.get(2, TimeUnit.SECONDS);
        MedalInfo medalInfo = completableMedalFuture.get();
        System.out.println("共用时：" + (System.currentTimeMillis() - startTime) + "ms");
    }
}
