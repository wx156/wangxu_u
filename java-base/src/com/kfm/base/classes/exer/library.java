package com.kfm.base.classes.exer;

public class library extends Book{
    private int[][] stack;
    public int[][] addBook(int a[][],int b,int c){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                a[i][j] = a[b][c];
            }

        }
        return a;
    }
}
