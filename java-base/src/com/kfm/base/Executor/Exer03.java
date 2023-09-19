package com.kfm.base.Executor;

import java.time.LocalTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Exer03 {
    public static void main(String[] args) {
        BlockingQueue<Runnable> abq = new ArrayBlockingQueue<>(10);

        ThreadPoolExecutor pool = new ThreadPoolExecutor(3,5,60, TimeUnit.SECONDS,abq);

        for (int i = 0; i < 10; i++) {
            int num = i;
            pool.execute(() -> System.out.println("当前时间 " + LocalTime.now() + "，线程：" + Thread.currentThread().getName() + "序号：" + num));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
