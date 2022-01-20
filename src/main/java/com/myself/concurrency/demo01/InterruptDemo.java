package com.myself.concurrency.demo01;

import java.util.concurrent.TimeUnit;

/**
 * @author yangshuai
 */
public class InterruptDemo {

	private static int i;

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				i++;
			}
			System.out.println(i);
		}, "interruptDemo");
		thread.start();
		TimeUnit.SECONDS.sleep(1);
		thread.interrupt();
	}
}
