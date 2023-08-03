package com.kfm.base.string;

import java.util.Arrays;

public class Work1 {
    public static void main(String[] args) {
        String colour [] = {"黑桃","梅花","方块","红桃"};
        String face [] = {"A","2","3","4","5","6","7","8","9","10","J","Q","k"};
        String a [][] = new String[colour.length][face.length];
        for (int i = 0; i < colour.length; i++) {
            for (int j = 0; j < face.length; j++) {
                 a[i][j] = colour[i]+ face[j];
            }
        }
        for (int i = 0; i < colour.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }
}
