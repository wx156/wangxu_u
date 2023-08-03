package com.kfm.base.array;

public class Arrayyy3 {
    public static void main(String[] args) {

        int [][] a = new int[][]{
            {11,13,24},
            {22,23,25},
            {33,34,36}
        };
        for (int i = 0;i < a.length;i++){
            for (int j = a.length-1;j >= 0;j--){

                System.out.println(a[i][j]);
            }


        }
        System.out.println();
    }
}
