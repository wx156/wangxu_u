package com.kfm.base.test;

import java.util.ArrayList;
import java.util.List;

public class Exer3 {
    public static void main(String[] args) {
        int a[] = {1, 0,1,1};
        int k = 1;
        System.out.println(isTrue(a, k));
    }

    private static boolean isTrue(int[] a, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j <= a.length; j++) {
                if (a[i] == a[j] || Math.abs(i - j) <= k) {
                    return true;
                }
            }

        }
        return false;
    }
}
