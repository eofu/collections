package com.myself.juc.a_000;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class T01_Thread {
	public static class T1 extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					TimeUnit.MICROSECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("T1");
			}
		}
	}

	public static void main(String[] args) {
		// new T1().start();
		new T1().run();
		for (int i = 0; i < 10; i++) {
			try {
				TimeUnit.MICROSECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("main");
		}
	}
}
