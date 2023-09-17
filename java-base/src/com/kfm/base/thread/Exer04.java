package com.kfm.base.thread;

public class Exer04 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("3"));
        thread.start();
        System.out.println(thread.getState().name());

    }
}
