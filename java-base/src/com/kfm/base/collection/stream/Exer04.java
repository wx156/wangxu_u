package com.kfm.base.collection.stream;

import java.util.ArrayList;

public class Exer04 {
    public static void main(String[] args) {
//        int [] arr = {2,3,5,6,8,4};

        ArrayList<Integer> arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        Double asDouble = arrayList.stream().mapToDouble(e -> e * e).average().getAsDouble();
        System.out.println(asDouble);

    }
}
