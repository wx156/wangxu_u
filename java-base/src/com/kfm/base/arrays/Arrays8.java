package com.kfm.base.arrays;

import java.util.Arrays;

public class Arrays8 {
    public static void main(String[] args) {

        // 设 names 数组中存放学生姓名
        String[] names = {"安琪拉", "王昭君", "蔡文姬", "妲己", "张良"};

// 设 courses 数组中依次存放三门课程的名称
        String[] courses = {"C++", "Java", "Python"};
// 设 scores 数组中依次存储的是 names 数组中各个学生的 C++ 、Java 、Python 课程的

        int[][] scores = {
                {90, 89, 75},
                {59, 40, 100},
                {100, 99, 80},
                {80, 61, 61},
                {60, 100, 99},
        };

        int [] sum = new int[scores.length];
        for (int i = 0; i < scores.length; i++) {
            int s = 0;
            for (int j = 0; j < scores[i].length ; j++) {


                s += scores[i][j];

            }
            sum[i] = s;

        }
        System.out.println(Arrays.toString(sum));
        for (int i = 0; i < sum.length-1; i++) {
            for (int j = 0; j < sum.length-1-i; j++) {
                if (sum[j] < sum[j+1]){
                    int temp = sum[j];
                    sum[j] = sum[j+1];
                    sum[j+1] = temp;

                    String t = names[j];
                    names[j] = names[j+1];
                    names[j+1] = t;

                    int []emp = scores[j];
                    scores[j] = scores[j+1];
                    scores[j+1] = emp;

                }
            }
        }
        System.out.println(Arrays.toString(sum));

        for (int i = 0; i < scores.length; i++) {
            System.out.print(names[i] + " => "); // 输出学生姓名
            for (int j = 0; j < scores[i].length; j++) {
                System.out.print(courses[j] + ":");// 输出课程名称
                System.out.print(scores[i][j]); // 输出课程成绩
                if (j < scores[i].length - 1) {
                    System.out.print(" , ");
                }
                System.out.print(" "+sum[i]+"\t");
            }
            System.out.println();
        }
    }
}

