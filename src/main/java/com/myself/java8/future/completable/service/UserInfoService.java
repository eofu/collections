package com.myself.java8.future.completable.service;

import com.myself.java8.future.completable.entity.UserInfo;

public class UserInfoService {
    public UserInfo getUserInfo(Long userId) throws InterruptedException {
        // 模拟调用耗时
        Thread.sleep(300);
        // 一般是查数据库，或者远程调用返回的
        return new UserInfo("666", "捡田螺的小男孩", 27);
    }
}
