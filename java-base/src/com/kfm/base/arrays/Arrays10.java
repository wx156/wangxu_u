package com.kfm.base.arrays;

public class Arrays10 {
    public static void main(String[] args) {

        int[][] a = new int[][]{
                {22, 4, 3, 55, 7, 9, 81},
                {33, 4, 52, 63, 7, 8, 10},
                {20, 39, 72, 6, 2, 4, 1},
                {30, 27, 33, 47, 89, 7, 9},
                {48, 6, 8, 7, 99, 38, 55}

        };
        int  min = a[0][0];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j]<min){
                    min = a[i][j];
                }
            }

        }
        int index = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {



        }
        System.out.println(index);

    }
}
