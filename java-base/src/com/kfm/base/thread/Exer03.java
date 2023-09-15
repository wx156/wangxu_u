package com.kfm.base.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Exer03 {
    public static void main(String[] args) {
        // 通过建立callable对象 ，然后将callable 对象传入 FutureTask 对象，再将 FutureTask 传入thread 创建新线程
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 5 * 4;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread r1 = new Thread(futureTask);
        r1.start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        // callable 的 lambda 表达式
        FutureTask futureTask1 = new FutureTask(() ->{
            return 5*2;
        });
        Thread thread = new Thread(futureTask1);
        thread.start();
        try {
            System.out.println(futureTask1.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
