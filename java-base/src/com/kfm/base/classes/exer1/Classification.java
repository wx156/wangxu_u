package com.kfm.base.classes.exer1;

import java.util.Arrays;
import java.util.Scanner;

public class Classification {
    public static void main(String[] args) {
        Scanner inpu = new Scanner(System.in);
        System.out.println("请输入要分类的字符串："+ "\n");
        String string = inpu.next();

        int smallCount = 0;
        int largeCount = 0;
        int numCount = 0;
        byte [] bytes = string.getBytes();
        System.out.println(Arrays.toString(bytes));
        for (int i = 0; i < bytes.length ;i++) {
            if (bytes[i]>= 97 && bytes[i] <= 122){
                smallCount++;
            }else if (bytes[i] >= 65 && bytes[i] <= 90){
                largeCount++;
            }else {
                numCount++;
            }
        }
        System.out.println("小写字母有" + smallCount + "个，大写字母有"+ largeCount + "个，数字有"+ numCount+"个。");
    }
}
