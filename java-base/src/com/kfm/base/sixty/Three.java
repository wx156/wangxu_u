package com.kfm.base.sixty;

public class Three {
    /*
    题目：打印出所有的 "水仙花数 "，所谓 "水仙花数 "是指一个三位数，其各位数字立方和等于该数本身。
    例如：153是一个 "水仙花数 "，因为153=1的三次方＋5的三次方＋3的三次方。
     */
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            if (((i / 100) * (i / 100) * (i / 100)) + ((i / 10 % 10) * (i / 10 % 10) * (i / 10 % 10))
                    + ((i % 10) * (i % 10) * (i % 10)) == i) {
                System.out.println(i);
            }

        }
    }
}
