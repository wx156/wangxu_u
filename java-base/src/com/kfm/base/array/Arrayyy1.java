package com.kfm.base.array;

import java.util.Scanner;

public class Arrayyy1 {
    public static void main(String[] args) {

        Scanner inpu = new Scanner(System.in);
        System.out.println("请输入一个值");
        int n = inpu.nextInt();
        int []a = {1,2,3,4,5,6,7,8};
        int left = 0;
        int right = a.length-1;
        int index = -1;
        while (left <= right){

            int mod = (right + left) >> 1;
            if (n == a[mod]){
                index = mod;
                break;
            } else if (n > a[mod]) {
                left = mod -1;

            }else {
                right = mod +1;

            }
        }
        System.out.println(index);


    }
}
