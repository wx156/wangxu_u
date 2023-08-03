package com.kfm.base.sixty;

public class One {
    /*
        题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，
        假如兔子都不死，问每个月的兔子总数为多少？
        这是一个菲波拉契数列问题
    */
    public static void main(String[] args) {
        int n = 10;
        int a = 1;
        int b = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1 || i == 2) {
                a = 1;
                b = 1;
            } else {
                int c = a + b;
                a = b;
                b = c;
            }

        }
        System.out.println(b);
    }
}
