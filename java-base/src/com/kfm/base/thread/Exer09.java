package com.kfm.base.thread;

import java.util.concurrent.CountDownLatch;

public class Exer09 {
    public static void main(String[] args) {
        ChangeI changeI = new ChangeI();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        Thread thread  = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 1000; j++) {
                    changeI.add();
                }
                countDownLatch.countDown();
            }
        });
        Thread thread1  = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 1000; j++) {
                    changeI.sub();
                }
                countDownLatch.countDown();
            }
        });

        for (int i = 0; i < 5; i++) {
            new Thread(thread).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(thread1).start();
        }

        thread1.start();
        thread.start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println(changeI.getI());
    }
}
class ChangeI {
    private int i = 0;
    public int add(){
        synchronized (this){
            i += 1;
        }
        return i;
    }
    public synchronized int sub(){
        synchronized (this){
            i -= 1;
        }
        return i;
    }
    public int getI() {
        return i;
    }
}