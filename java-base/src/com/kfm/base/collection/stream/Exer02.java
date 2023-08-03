package com.kfm.base.collection.stream;

import java.util.Arrays;

public class Exer02 {
    public static void main(String[] args) {
        int [] a = {2,3,4,66,7,9};
        System.out.println("最大值为：" + Arrays.stream(a).max().getAsInt());
        System.out.println("最小值为：" + Arrays.stream(a).min().getAsInt());

        System.out.println("元素之和为："+ Arrays.stream(a).sum());
    }
}
