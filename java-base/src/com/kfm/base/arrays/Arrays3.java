package com.kfm.base.arrays;

public class Arrays3 {
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
        for (int i = 0; i < scores.length-1; i++) {
            for (int j = 0; j < scores.length - 1; j++) {
                if (scores[j][1] < scores[j+1][1]){
                    int []temp = scores[j];
                    scores[j] = scores[j+1];
                    scores[j+1] = temp;

                    String t = names[j];
                    names[j] = names[j+1];
                    names[j+1] = t;
                }
            }

        }

        for (int i = 0; i < scores.length; i++) {
            System.out.print(names[i] + " => "); // 输出学生姓名
            for (int j = 0; j < scores[i].length; j++) {
                System.out.print(courses[j] + ":");// 输出课程名称
                System.out.print(scores[i][j]); // 输出课程成绩
                if (j < scores[i].length - 1) {
                    System.out.print(" , ");
                }
            }
            System.out.println();
        }
    }
}
