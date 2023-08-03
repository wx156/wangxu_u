package com.kfm.base.string;

import java.util.Random;

public class Exercise2 {
    public static void main(String[] args) {
        Random a = new Random();
        int[] b = new int[6];
        String password = "";

        for (int i = 0; i < 6; i++) {
            b[i] = a.nextInt(47) + 74;
            if ((b[i] > 57 && b[i] < 65) || (b[i] > 90 && b[i] < 97)) {
                i--;
            } else {
                char s = (char) b[i];
                password += s;
            }
        }
        System.out.println(password);
    }
}