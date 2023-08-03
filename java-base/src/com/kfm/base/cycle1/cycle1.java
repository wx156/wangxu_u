package com.kfm.base.cycle1;

import java.util.Scanner;

public class cycle1 {
    public static void main(String[] args) {

        /*
            素数（质数）只能被 1 和 他本身整除的数
            相反就是合数

            判断输入的数是否是 素数

            break 在 switch 执行 break 表示 switch 执行结束。终止了
              在循环(for、while、do-while)中, 执行到 break 表示当前循环终止、结束了。
         */
        Scanner sc = new Scanner(System.in);

        System.out.println("输入一个数：");
        int num = sc.nextInt(); // 9   7

            for (int i = 1; i <= num >> 1; i ++){
                if (num % i == 0){
                    System.out.println(num + " 不是素数");
                    break;
                }
                if (i == num >> 1 && num != 1){ // 是最后一次循环了
                    System.out.println(num + " 是素数");
                }
            }
    }
}
