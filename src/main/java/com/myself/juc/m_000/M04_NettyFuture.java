package com.myself.juc.m_000;

import com.myself.utils.DateUtils;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;

import java.util.concurrent.CountDownLatch;

public class M04_NettyFuture {
    public static void main(String[] args) throws InterruptedException {
        EventExecutorGroup group = new DefaultEventExecutorGroup(4);
        System.out.println("开始:" + DateUtils.getNow());

        Future<Integer> f = group.submit(() -> {
            System.out.println("开始耗时计算:" + DateUtils.getNow());
            Thread.sleep(10000);
            System.out.println("结束耗时计算:" + DateUtils.getNow());
            return 100;
        });

        f.addListener(new FutureListener<Object>() {
            @Override
            public void operationComplete(Future<Object> objectFuture) throws Exception {
                System.out.println("计算结果:" + objectFuture.get());
            }
        });

        System.out.println("结束:" + DateUtils.getNow());
        // 不让守护线程退出
        new CountDownLatch(1).await();
    }
}
