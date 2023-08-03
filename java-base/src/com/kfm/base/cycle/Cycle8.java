package com.kfm.base.cycle;

public class Cycle8 {
    public static void main(String[] args) {
        for (int row = 3; row >= 0; row --) {
            // 空格
            for (int i = 1; i <= 2 * row +2; i++) {
                System.out.print(" ");
            }
            // *
            for (int i = 1; i <= 2 * (3 - row) + 1; i++) {
                System.out.print("* ");

            }
            System.out.println();
        }
        for (int row = 3; row >= 0; row --) {
            // 空格
            for (int i = 1; i <= 2 * row +2; i++) {
                System.out.print(" ");
            }
            // *
            for (int i = 1; i <= 2 * (3 - row) + 1; i++) {
                System.out.print("* ");

            }
            System.out.println();
        }
        for (int e = 1; e<= 4;e++){
            for (int f = 1;f<= 7;f++){
                System.out.print(" ");
            }

            for (int g = 0;g<=3;g++){
                for (int h = 7;h<8;h++){
                    System.out.print("#");
                }
            }
            System.out.println();
        }
        System.out.println();


    }
}
