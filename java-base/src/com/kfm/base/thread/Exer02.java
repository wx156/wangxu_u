package com.kfm.base.thread;

public class Exer02 {
    public static void main(String[] args) {
        //一个类实现了 runnable 接口，新建其对象可以给 thread 传入一个runnable对象，以此来创建新线程
        Mythread my = new Mythread();
        Thread r1 = new Thread(my);
        Thread r2 = new Thread(my);

        r1.start();
        r2.start();

        // 也可以用 runnable 匿名函数来新建一个 Runnable 对象，然后给 thread 传入一个 runnable 对象，以此来创建新线程
        Runnable runnable = () -> {
           String name = Thread.currentThread().getName();
            for (int i = 0; i < 10; i++) {
                System.out.println(i+ name);
            }

        };
        Thread runab1 = new Thread(runnable);
        Thread runab2 = new Thread(runnable);

        runab1.start();
        runab2.start();


    }
}
class Mythread implements Runnable{
    Mythread(){
        super();
    }
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10; i++) {
            System.out.println(name + 2* i);
        }
    }
}
