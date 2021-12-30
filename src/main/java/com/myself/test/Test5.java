package com.myself.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Test5 {


    static ScheduledExecutorService ses = Executors.newScheduledThreadPool(5);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Object> objects = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int i1 = new Random().nextInt(5000);
            System.out.println("task:" + i + "   " + i1);
            ScheduledFuture schedule = ses.schedule(new Callable() {
                @Override
                public Object call() throws Exception {
                    int add = add(new Random().nextInt(), new Random().nextInt());
                    return add;
                }
            }, i1, TimeUnit.MILLISECONDS);
            objects.add(i1);
            objects.add(schedule.get());
        }
        for (Object object : objects) {
            System.out.println(object);
        }
    }

    public static int add(int a, int b) {
        return a + b;
    }
}
