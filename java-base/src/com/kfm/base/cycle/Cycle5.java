package com.kfm.base.cycle;

public class Cycle5 {

    public static void main(String[] args) {
        int a = 7;

        while (a >= 2) {
            a--;
            for (int i = a; i <= 6; i++) {
                System.out.print("* ");

            }
            System.out.println();
        }


    }
}
