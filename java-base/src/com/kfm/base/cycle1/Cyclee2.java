package com.kfm.base.cycle1;

public class Cyclee2 {
    public static void main(String[] args) {

       for (int i = 5;i>= 0;i--){
           for (int j = 1;j<= i;j++){
               System.out.print(" ");
           }
           System.out.println();
           for (int j = 1;j <= 2*i-1;j++){
               System.out.print("*");
           }
           System.out.println();
       }
       System.out.println();



    }
}
