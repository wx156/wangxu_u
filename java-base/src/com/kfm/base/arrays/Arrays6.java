package com.kfm.base.arrays;

public class Arrays6 {
    public static void main(String[] args) {

        int[] nums = {2, 11, 33, 44, 55, 66, 277};
        int[] newNums = new int[nums.length-1];
        System.arraycopy(nums,3,newNums,3,2);
    }
}
