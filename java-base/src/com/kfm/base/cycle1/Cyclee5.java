package com.kfm.base.cycle1;

import java.util.Scanner;

public class Cyclee5 {
    public static void main(String[] args) {

        if (1 == 1) {
            Scanner input = new Scanner(System.in);
            System.out.print("输入李四跑的天数：");
            int days = input.nextInt();
            int sum = 0;
            int monday = 0;
            int s = 0;
            int count = 0;
            for (int i = 0; i < days / 7; i++) {
                count++;
                monday += 100;
                s = monday;
                for (int j = 0; j < 7; j++) {
                    sum += s;
                    s += 100;
                }
            }
            if (days % 7 != 0) {
                int s1 = 100 * (count + 1);
                for (int m = 0; m < days % 7; m++) {
                    sum += s1;
                    s1 += 100;
                }
            }
            System.out.println("淦，终于跑完了" + sum + "米");
        }




            }
}
