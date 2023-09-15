package com.kfm.base.sixty;

import java.util.Scanner;

public class Four {
    /*
    题目：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
    程序分析：对n进行分解质因数，应先找到一个最小的质数k，然后按下述步骤完成：
    (1)如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印出即可。
    (2)如果n > k，但n能被k整除，则应打印出k的值，并用n除以k的商,作为新的正整数你n,重复执行第一步。
    (3)如果n不能被k整除，则用k+1作为k的值,重复执行第一步。
    */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个正整数");
        int x = input.nextInt();
        System.out.print(x+"=");
        int i=2;
        while(i<=x) {        //使用循环来找到可以被整除的数，然后通过out函数输出
            if (i == x) {        //如果相等的话，就说明这个数没有因数，只有1和它自己；
                System.out.println(i);
                break;
            } else if (x % i == 0) {        //如果这个数有因数，然后找到除去这个因数后的值，继续循环
                System.out.print(i + "*");
                x = x / i;
            } else {            //如果都不满足，则继续循环
                i++;
            }
        }
    }
}
