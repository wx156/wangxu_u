package com.kfm.base.cycle1;

public class Cycleplus {

    public static void main(String[] args) {


        int num = 30;
        while (num >1){
            out:for (int i = 2;i <= num;i++){
                for (int j = 1; j <= i >>1;j++){
                    if (j !=1 && i % j ==0){

                        continue out;

                    }

                }
                if (num % i ==0){
                    System.out.println(i);
                    num /= i;
                    break ;
                }

            }

        }


    }
}
