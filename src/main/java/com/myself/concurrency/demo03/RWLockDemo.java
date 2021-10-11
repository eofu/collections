package com.myself.concurrency.demo03;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// 共享锁，读多写少
public class RWLockDemo {

	static Map<String, Object> cacheMap = new HashMap<>();

	static ReentrantReadWriteLock rw = new ReentrantReadWriteLock();

	static Lock readLock = rw.readLock();// 读锁
	static Lock writeLock = rw.writeLock();// 写锁

	// 缓存的更新和读取
	public static Object get(String key) {
		readLock.lock();
		try {
			return cacheMap.get(key);
		} finally {
			readLock.unlock();
		}
	}

	public static Object set(String key, Object value) {
		writeLock.lock();
		try {
			return cacheMap.put(key, value);
		} finally {
			writeLock.unlock();
		}
	}
}
