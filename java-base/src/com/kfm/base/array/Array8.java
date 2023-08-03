package com.kfm.base.array;

public class Array8 {
    public static void main(String[] args) {

        int[] arr = {9, 1, 3, 4, 54, 56, 23, 22, 20, 43, 45, 78};
//每个数排列一次
        for (int i = 0; i < arr.length - 1; i++) {
//将这个数%2看是否等于0，如果等于0则将这个数与后一个数字交换
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] % 2 == 0) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int s : arr
        ) {
            System.out.print(s + " ");
        }

    }
}
