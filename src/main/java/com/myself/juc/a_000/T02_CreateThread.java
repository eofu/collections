package com.myself.juc.a_000;

/*
启动线程的方式：
1、Thread
2、Run
3、Executors.newCachedThread()
 */
public class T02_CreateThread {
	static class MyThread extends Thread{
		@Override
		public void run() {
			System.out.println("thread");
		}
	}

	static class MyRun implements Runnable{
		@Override
		public void run() {
			System.out.println("Run");
		}
	}

	public static void main(String[] args) {
		new MyThread().start();
		new Thread(new MyRun()).start();
		new Thread(() -> System.out.println("lambda")).start();
	}
}
