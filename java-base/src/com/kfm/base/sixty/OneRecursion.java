package com.kfm.base.sixty;

public class OneRecursion {
    public static int fib(int n) {
        if (n <= 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        int a = fib(10);
        System.out.println(a);
    }
}
