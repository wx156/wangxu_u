package com.kfm.base.array;

public class Array3 {
    public static void main(String[] args) {

        int[] a = {2, 4, 33, 5, 66, 73,};
        for (int i = 0; i < a.length; i++) {

            if (i % 2 == 0) {
                continue;
            } else if (a[i] % 2 == 0) {
                continue;
            } else
                System.out.println("输出的索引是：" + i);
            System.out.println("输出的元素是" + a[i]);
        }
    }
}
