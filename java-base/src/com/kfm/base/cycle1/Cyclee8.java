package com.kfm.base.cycle1;

public class Cyclee8 {
    public static void main(String[] args) {
        int sum = 0;
        out:
        for (int i = 2; i <= 100; i++) {
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    continue out;
                }
            }
            sum += i;
        }
        System.out.println(sum);

    }

}




