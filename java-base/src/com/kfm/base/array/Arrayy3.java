package com.kfm.base.array;

import java.util.Arrays;

public class Arrayy3 {
    public static void main(String[] args) {
        int t = 0;
        int []a = {2,2,33,33,4,5,33,4,6,7,3,2,};
        for (int i = 0; i < a.length;i++){
            for (int j = 1;j < a.length-i-2;j++){
                if (a[i] == a[j] && a[i] != 0){
                    a[i] = 0;

                }


            }

        }
        System.out.println(Arrays.toString(a));
        for (int i = 0;i < a.length;i++){
            if (a[i] == 0){
                t ++;
            }

        }
        int [] b = new int[a.length-t];
        for (int i = 0;i< a.length;i++){

//            if (a[i] != 0 && i < t){
//
//                b[i] = a[i];
//            }else
           if (a[i] != 0){
                b[i-t] = a[i];
            }


        }
        System.out.println(Arrays.toString(b));




    }
}
