package com.kfm.base.array;

import java.util.Random;

public class Array2 {
    public static void main(String[] args) {
        Random r = new Random();
        double sum = 0;
        double[] a = new double[6];
        for (int i = 0; i < 6; i++) {

            a[i] = r.nextDouble(100);
            for (int j = 0; j <= a.length; j++) {


            }
            sum += a[i];
        }
        System.out.println(sum);
    }
}
