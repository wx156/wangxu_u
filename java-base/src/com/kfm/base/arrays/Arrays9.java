package com.kfm.base.arrays;

import java.util.Arrays;

public class Arrays9 {
    public static void main(String[] args) {

        int[]a = {1,2,3,4,5,};
        int [] b = new int[a.length+1];
        Arrays.fill(b,6);
        System.arraycopy(a,0,b,0,3);
        System.arraycopy(a,3,b,4,2);
        System.out.println(Arrays.toString(b));
    }
}
