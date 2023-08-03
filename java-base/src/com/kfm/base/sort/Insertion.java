package com.kfm.base.sort;

import java.util.Arrays;

public class Insertion {
    public static void main(String[] args) {
        int[] a = {3, 2, 55, 33, 76, 48, 9, 20, 66};
        for (int i = 1; i < a.length; i++) {
            int current = a[i]; //取第i个数
            int preIndex = i-1; //取第i+1个数的下标

            while (preIndex >= 0 && a[preIndex] > current){
                a[preIndex + 1] = a[preIndex]; //如果第i个后面的数大于第i个数，第i个数后移
                preIndex --; //减减是为了能和前面的数比较
            }
            a[preIndex +1] = current; //将这个用于比较的数赋值给比较完后小于这个数的前面一个数
        }
        System.out.println(Arrays.toString(a));


    }
}
