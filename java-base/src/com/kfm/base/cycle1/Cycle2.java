package com.kfm.base.cycle1;

public class Cycle2 {

    public static void main(String[] args) {
        /*
            输出 (1, 100] 间所有的 素数（质数）
         */

        for (int num = 1; num <= 100; num++) {
            for (int i = 1; i <= num >> 1; i++) {
                if (i != 1 && num % i == 0) {
                    break;
                }
                if (i == num >> 1) { // 是最后一次循环了
                    System.out.println(num + " 是素数");
                }
            }
        }

    }
}
