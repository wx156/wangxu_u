package com.kfm.base.thread;

public class Exer08 {
    public static void main(String[] args) {
        SellTicket sellTicket= new SellTicket();
        Thread thread1 = new Thread(sellTicket,"窗口一");
        Thread thread2 = new Thread(sellTicket,"窗口二");
        Thread thread3 = new Thread(sellTicket,"窗口三");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class SellTicket implements Runnable {

    // 总票数
    private int tickets = 100;

    private Object obj = new Object(); // 锁

    @Override
    public void run() {
        // 每一个任务都是一个售票的窗口
        while (true) { // 售票窗口一直开放
            synchronized (obj) { // 同步
                // 当票没卖完时，可以买票
                if (tickets > 0) {
                    try {
                        // 模拟付钱和出票过程
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    // 购票成功
                    System.out.println(Thread.currentThread().getName() + " 售出第 【" + tickets-- + "】 张票");
                }
            }
        }
    }
}