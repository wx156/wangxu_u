package com.kfm.base.cycle1;

public class Cyclee3 {
    public static void main(String[] args) {
        int sum =0;
        for (int i = 1;i <= 10;i++){
            for (int j = 1;j <= 1<<(i - 1);j++){
                if (j == 1<<(i - 1)){
                    sum += j;
                    System.out.println(sum);
                }

            }
        }
    }
}
