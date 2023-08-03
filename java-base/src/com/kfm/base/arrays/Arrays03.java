package com.kfm.base.arrays;

import java.util.Arrays;

public class Arrays03 {

    public static int []move(int a[],int b){
        int []newa = new int[a.length-1];
        System.arraycopy(a,0,newa,0,b);
        System.arraycopy(a,b+1,newa,b,a.length-b -1);
        return newa;
    }
    public static void main(String[] args) {
        int a []= {1,2,3,4,5,6,7};
        int b = 4;
        int s[] = move(a,b);
        System.out.println(Arrays.toString(s));
    }
}
