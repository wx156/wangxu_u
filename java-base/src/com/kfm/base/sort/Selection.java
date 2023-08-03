package com.kfm.base.sort;

import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        int[] a = {3, 2, 55, 33, 76, 48, 9, 20, 66};
        for (int i = 0; i < a.length - 1; i++) { //从第一个数开始比较
            int min = i;
            for (int j = i + 1; j < a.length; j++) { //内层循环遍历i+1到最后一个数
                if (a[j] < a[min]) {
                    min = j; //标记找到的数
                }
            }
            int temp = a[min]; //和找到的数交换位置
            a[min] = a[i];
            a[i] = temp;
        }
        System.out.println(Arrays.toString(a));
    }
}
