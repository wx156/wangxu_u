package com.kfm.base.arrays;

import java.util.Arrays;

public class Arrays5 {
    public static void main(String[] args) {
        int[] nums = {2, 11, 33, 44, 55, 66, 277};
        int []newNums = new int[nums.length-1];
//      newNums = {2, 11, 44,55, 66, 277}
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] == 33 && i == 2) {
                continue;

            } else if (i <= 2) {
                newNums[i] = nums[i];
            } else{
                newNums[i-1] = nums[i];
            }

        }
        System.out.println(Arrays.toString(newNums));
    }
}
