package com.myself.concurrency.demo03;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 对标synchronized
public class LockDemo {
	// 公平重入锁和非公平重入锁
	static Lock lock = new ReentrantLock();

	private static int count = 0;

	public static void inCr() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lock.lock();// 获得锁
		count++;
		lock.unlock();// 释放锁
	}
}
