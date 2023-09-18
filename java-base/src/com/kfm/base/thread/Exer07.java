package com.kfm.base.thread;

import java.util.Arrays;

public class Exer07 {
    public static void main(String[] args) {

        int [] a = {5,3,4,6,7,2,9,1,8};
        Thread test1 =new Thread(new Test(a,0,3));
        Thread test2 =new Thread(new Test(a,3,6));
        Thread test3 =new Thread(new Test(a,6,9));

        test1.start();
        test2.start();
        test3.start();

        try {
            test1.join();
            test2.join();
            test3.join();//等待线程死亡，等待这些线程运行完才会执行其他的线程
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println(Arrays.toString(a));
    }

}
class Test implements Runnable{

    private int[]num;
    private int start;
    private int end;

    public Test(int[] num, int start, int end) {
        this.num = num;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        Arrays.sort(num,start,end);
    }

}
