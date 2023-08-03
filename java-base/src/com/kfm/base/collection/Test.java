package com.kfm.base.collection;

import java.util.Scanner;
import java.util.Vector;

public class Test {
    public static void main(String[] args) {
        Commodity c1 = new Commodity("书");
        Commodity c2 = new Commodity("笔");
        Commodity c3 = new Commodity("薯片");

        Scanner inp = new Scanner(System.in);


        Vector vector = new Vector();
        vector.add(c1);
        vector.add(c2);
        vector.add(c3);



        System.out.println("请输入一个商品名称：");
        String str = inp.next();

        Boolean flag = contains(str,vector);
        System.out.println(flag);

    }
    public static Boolean contains(String str,Vector v){
        if (str == null || v == null){
            return false;
        }else {
            for (int i = 0; i < v.size(); i++) {
                if (v.get(i) instanceof Commodity){
                    Commodity commodity = (Commodity) v.get(i);
                    if (str.compareTo(commodity.getName()) == 0);
                    System.out.println(v.get(i));
                    return true;
                }
            }
        }
        return false;
    }
}
