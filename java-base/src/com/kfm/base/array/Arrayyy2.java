package com.kfm.base.array;

import java.util.Arrays;

public class Arrayyy2 {
    public static void main(String[] args) {

        int []a = {2,3,1,8,3,9,6};

        for (int i = 1;i < a.length;i++){
            int cu =a[i];
            int pr = i-1;
            while (pr >= 0 && a[pr] > cu){
                a[pr +1] = a[pr];
                pr --;

            }
            a[pr +1] = cu;

        }
        System.out.println(Arrays.toString(a));

    }
}
