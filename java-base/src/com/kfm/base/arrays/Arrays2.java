package com.kfm.base.arrays;

public class Arrays2 {
    public static void main(String[] args) {

        char[][] chunxiao = {
                {'春', '眠', '不', '觉', '晓'},
                {'处', '处', '闻', '啼', '鸟'},
                {'夜', '来', '风', '雨', '声'},
                {'花', '落', '知', '多', '少'}
        };
        for (int i = 0; i < chunxiao[0].length; i++) {
            for (int j = chunxiao.length - 1; j >= 0; j--) {
                System.out.print(chunxiao[j][i]);


            }
            System.out.println();
        }
    }
}
