package com.kfm.base.Executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Exer04 {
    public static void main(String[] args) {
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(2,2,10L, TimeUnit.SECONDS,new ArrayBlockingQueue<>(10));
        tpe.execute(() -> {
            for (int i = 1; i < 11; i++) {
                if (i % 2 != 0){
                    System.out.println(i);
                    try {
                        Thread.currentThread().join(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        tpe.execute(() -> {
            for (int i = 1; i < 11; i++) {
                if (i % 2 == 0){
                    System.out.println(i);
                    try {
                        Thread.currentThread().join(1099);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }
}
