package com.kfm.base.sort;

public class Binarysearch {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = 5; //你要查找的数
        int left = 0; //第一个数的下标
        int right = a.length - 1; //最后一个数的下标
        int index = -1; //定义一个标志量
        while (left <= right) {
            int middle = (left + right) >> 1; //定义一个中值下标
            if (a[middle] == n) {
                index = middle; //如果a[middle]等于n,说明找到了
                break;
            } else if (a[middle] < n) {
                left = middle + 1; //当a[middle]<n时，说明middle在要找的数左边，然后左边的标志量右移至middle右边一位
            } else
                right = middle - 1; //当啊a[middle]>n时，说明middle在要找的书的右边，右边的标志量左移到middle左边一位
        }
        System.out.println(index);
    }
}
