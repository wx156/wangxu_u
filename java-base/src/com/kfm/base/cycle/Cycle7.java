package com.kfm.base.cycle;

public class Cycle7 {
    public static void main(String[] args) {

        for (int row = 6; row >= 0; row --) {
            // 空格
            for (int i = 1; i <= 2 * row +2; i++) {
                System.out.print(" ");
            }
            // *
            for (int i = 1; i <= 2 * (6 - row) + 1; i++) {
                System.out.print("* ");

            }
            System.out.println();
        }
        for (int row = 0; row <= 7; row ++) {
            // 空格
            for (int i = 1; i <= 2 * row; i++) {
                System.out.print(" ");
            }
            // *
            for (int i = 1; i <= 2 * (7 - row) + 1; i++) {
                System.out.print("* ");

            }
            System.out.println();
        }


    }
}
