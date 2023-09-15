package com.kfm.base.thread;

public class Exer01 {
    public static void main(String[] args) {
        Text text = new Text();
        String name = Thread.currentThread().getName();
        text.start();
        for (int i = 0; i < 20; i++) {
            System.out.println(name);
        }

    }
}
class Text extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            String name = Thread.currentThread().getName();
            System.out.println(name + (5*i));
        }

    }
}
