package com.kfm.base.string;

import java.util.Random;

public class Exercise5 {
    public static void main(String[] args) {
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String pass = "";
        int a[] = new int[6];
        Random r = new Random();
        do {
            for (int i = 0; i < 6; i++) {
                a[i] = r.nextInt(63);
                pass += base.charAt(a[i]);
            }
        }while (!determine(pass));
    }
    public static boolean determine(String str){
        return true;
    }
}
