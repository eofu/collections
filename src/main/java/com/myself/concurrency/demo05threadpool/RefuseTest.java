package com.myself.concurrency.demo05threadpool;

import java.util.concurrent.*;

public class RefuseTest implements RejectedExecutionHandler {
    public static void main(String[] args) {
        ThreadPoolExecutor threadpool = new ThreadPoolExecutor(3, 5, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
        
    }
    
    public void refuse1AbortPolicy() {
        // ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), rejectedExecution());
    }
    
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
    
    }
}
