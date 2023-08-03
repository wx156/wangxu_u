package com.kfm.base.sort;

import java.util.Arrays;

public class Quicksort {
    public static void quickSort(int[]a){
        quickSort(a,0,a.length-1);
    }
    public static void quickSort(int []a,int begin,int end){
        if (begin > end){
            return;
        }
        int left = begin;
        int right = end;
        int base = a[begin];
        while (left < right){
            while (left < right && a[right] >= base){
                right--;
            }
            while (left < right && a[left] <= base){
                left++;
            }

            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
        }
        a[begin] = a[left];
        a[left] = base;

        quickSort(a,begin,left -1);
        quickSort(a,left+1,end);
    }

    public static void main(String[] args) {
        int a [] = {1,33,2,4,66,22};
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }
}
