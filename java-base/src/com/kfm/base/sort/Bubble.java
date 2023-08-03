package com.kfm.base.sort;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] a = {3, 2, 55, 33, 76, 48, 9, 20, 66};


        for (int i = 0; i < a.length - 1; i++) { //外层循环表示比较的次数
            for (int j = 0; j < a.length - 1 - i; j++) { //内层循环表示要和多少个数字进行比较
                if (a[j + 1] < a[j]) { //用一个数和他的前一个数进行比较
                    //如果前一个数比当前位置的数大就交换位置
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
