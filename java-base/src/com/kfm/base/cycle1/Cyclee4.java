package com.kfm.base.cycle1;

import java.util.Scanner;

public class Cyclee4 {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("请输入你想要的边长：");
        int n = input.nextInt();

        for (int i = 1;i <= n;i++){
            for (int j =1;j<=n;j++){
                if ((i == 1 || i == n) &&(j ==1 || j ==n)){
                    System.out.print("# ");




                }else if ((i >1 && i<n) && (j>1 && j<n)){
                    System.out.print("* ");
                }
                else{
                    System.out.print("@ ");
                }

            }
            System.out.println();
        }

    }
}
