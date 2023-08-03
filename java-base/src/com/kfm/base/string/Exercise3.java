package com.kfm.base.string;

import java.util.Arrays;
import java.util.Random;

public class Exercise3 {


    public static void main(String[] args) {
        int[] arr = new int[20];

        Random rand = new Random();
        for (int i = 0; i < arr.length; ) {
            int num = rand.nextInt(40) + 1;
            Arrays.sort(arr, 0, i);
            if (Arrays.binarySearch(arr, 0, i, num) < 0) {
                arr[i++] = num;
            }
        }

        charge(arr);
        charge(arr);
        charge(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void charge(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(arr.length);
            int index1 = random.nextInt(arr.length);

            int temp = arr[index];
            arr[index] = arr[index1];
            arr[index1] = temp;
        }
    }
}
