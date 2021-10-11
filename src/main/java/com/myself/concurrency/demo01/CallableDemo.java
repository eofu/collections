package com.myself.concurrency.demo01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallableDemo implements Callable<String> {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
	}

	@Override
	public String call() throws Exception {
		return "string" + 1;
	}
}
