package com.kfm.base.thread;

public class Exer05 {
    public static void main(String[] args) {
        Thread text1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.println(Thread.currentThread().getName() +":"+ (i*2 - 1));
                }
            }
        });
        Thread text2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 1; j <= 5; j++) {
                    System.out.println(Thread.currentThread().getName() +":"+ (j*2));
                }
            }
        });
        text1.start();
        text2.start();
    }
}
