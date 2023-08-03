package com.kfm.base.method;

public class Primenumber {
    public static int primeNuber(int a) {
        int i;
        if (a == 1) {
            System.out.println(a + "不是素数");
        }else {
            for (i = 2; i < a >> 1; i++) {
                if (a % 2 == 0){
                    System.out.println(a + "不是素数");
                    break;
                }
            }
            if (i > a >> 2){
                System.out.println(a + "是素数");
            }
        }
        return -1;
    }

//    public static void main(String[] args) {
//        int a = 7;
//        primeNuber(a);
//    }
}
