package com.myself.java8.future.test;

import com.myself.java8.future.completable.entity.MedalInfo;
import com.myself.java8.future.completable.service.MedalService;
import com.myself.java8.future.completable.entity.UserInfo;
import com.myself.java8.future.completable.service.UserInfoService;
import com.myself.utils.SnowFlakeIdWorker;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        UserInfoService userInfoService = new UserInfoService();
        MedalService medalService = new MedalService();
        Long userId = SnowFlakeIdWorker.generateId();
        long startTime = System.currentTimeMillis();

        // 调查用户服务获取用户基本信息
        FutureTask<UserInfo> userInfoFutureTask = new FutureTask<>(() -> userInfoService.getUserInfo(userId));
        executorService.submit(userInfoFutureTask);

        // 模拟其他耗时操作
        Thread.sleep(300);

        FutureTask<MedalInfo> medalInfoFutureTask = new FutureTask<>(() -> medalService.getMedalInfo(userId));
        executorService.submit(medalInfoFutureTask);

        UserInfo userInfo = userInfoFutureTask.get();
        MedalInfo medalInfo = medalInfoFutureTask.get();

        System.out.println("共用时" + (System.currentTimeMillis() - startTime) + "ms");
    }
}
