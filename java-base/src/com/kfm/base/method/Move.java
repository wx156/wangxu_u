package com.kfm.base.method;

public class Move {

    public static void shiftLeft(int[] arr, int k) {
        // 确保 k 小于或等于数组的长度
        if (k > arr.length) {
            k = arr.length;
        }

        // 将 k 个元素的值设置为数组最后的 k 个元素
        for (int i = arr.length - 1; i >= k; i--) {
            arr[i + k] = arr[i];
        }

        // 将数组前 k 个元素的值设置为 0
        for (int i = 0; i < k; i++) {
            arr[i] = 0;
        }
    }




}
