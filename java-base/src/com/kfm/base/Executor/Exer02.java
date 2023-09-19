package com.kfm.base.Executor;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Exer02 {
    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);

        for (int i = 0; i < 8; i++) {
            int number = i;
            pool.schedule(new Runnable() {
                public void run() {
                    System.out.println("当前时间:" + LocalTime.now() + ", 线程: " +
                            Thread.currentThread().getName() + ", 序号：" + number);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, 5, TimeUnit.SECONDS);
        }
    }
}
