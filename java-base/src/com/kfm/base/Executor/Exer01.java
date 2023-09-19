package com.kfm.base.Executor;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exer01 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        System.out.println("当前时间" + LocalTime.now());
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
