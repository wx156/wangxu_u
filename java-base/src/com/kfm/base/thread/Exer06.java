package com.kfm.base.thread;

public class Exer06 {

    public static void main(String[] args) {
       Text text = new Text();

       text.start();
        try {
            text.join(5000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
class Test extends Thread{
    @Override
    public void run() {
        int i = 4;
        while (i != Integer.MAX_VALUE){
            i++;
        }
    }
}
