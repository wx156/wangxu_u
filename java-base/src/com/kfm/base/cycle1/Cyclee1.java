package com.kfm.base.cycle1;

public class Cyclee1 {
    public static void main(String[] args) {

        int r = 8;
        for (int row = r; row >= 0; row --){
            // 空格
            for (int i = 1; i <= 2 * row; i ++){
                System.out.print(" ");
            }
            // *
            for (int i = 1; i <= 2 * (r - row) + 1; i ++){
                if (i == 1 || i == 2 * (r - row) + 1 || row == 0){
                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }
}
