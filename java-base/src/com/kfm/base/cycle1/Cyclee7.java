package com.kfm.base.cycle1;

public class Cyclee7 {
    public static void main(String[] args) {

        int num = 12345,num1 = num;
        int count = 5;
        int r = 0;


        for (int i = 0;i <= count;i++){

            int l = num % 10;
            r += l*10 ;

            num /= 10;







        }
        System.out.println(num);
    }
}
