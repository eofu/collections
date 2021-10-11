package com.myself.concurrency.demo04;

import java.util.concurrent.Semaphore;

public class SemaphonreDemo {
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(5);
		for (int i = 0; i < 10; i++) {
			new DoSomething(i, semaphore).start();
		}
	}

	static class DoSomething extends Thread {
		private final int num;
		private final Semaphore semaphore;

		public DoSomething(int num, Semaphore semaphore) {
			this.num = num;
			this.semaphore = semaphore;
		}

		@Override
		public void run() {
			try {
				semaphore.acquire(); // 获取一个令牌
				System.out.println("第" + num + "个线程进入");
				Thread.sleep(2000);
				semaphore.release(); // 释放令牌
				System.out.println("线程" + num + "释放令牌");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
