package com.kfm.base.string;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("请输入电子邮箱号");
        String a = inp.next();

        boolean flag = true;
        boolean isExist = a.endsWith(".com");
        int atFirstAppear = a.indexOf("@");
        int atlastAppear = a.lastIndexOf("@");
        int comFirstAppear = a.indexOf(".com");
        if (comFirstAppear == -1 || atFirstAppear == -1 || !isExist){
            flag = false;
        }else {
            if (atlastAppear != atFirstAppear){
                flag = false;
            }else {
                if (atlastAppear == comFirstAppear){
                    flag = false;
                }
            }
            flag = true;
        }
        if (flag){
            System.out.println("你输入的"+"("+ a +")"+"是一个合法的邮箱");
        }else {
            System.out.println("你输入的"+"("+ a +")"+"不是一个合法的邮箱");
        }
    }
}

