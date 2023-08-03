package com.kfm.base.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Arrays01 {
    public static int [] add(int a[],int b,int c) {
        int []newa =new int[a.length+1];
        System.arraycopy(a,0,newa,0,b);
        System.arraycopy(a,b,newa,b+1,newa.length-1-b);
        newa[b] = c;
        return newa;
    }

    public static void main(String[] args) {
        int a [] = {1,2,3,4,5,6,7};
        Scanner in = new Scanner(System.in);
        System.out.println("请输入要插入的位置");
        int b = in.nextInt();
        System.out.println("请输入要插入的数");
        int c = in.nextInt();
        System.out.println(Arrays.toString(add(a,b,c)));
    }
}
