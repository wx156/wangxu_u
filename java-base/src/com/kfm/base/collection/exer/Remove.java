package com.kfm.base.collection.exer;

import java.util.ArrayList;

public class Remove {
    public static void main(String[] args) {

        ArrayList<String> strs = new ArrayList<>();
        strs.add("abcd");
        strs.add("aud");
        strs.add("agd");
        strs.add("abvd");
        strs.add("acd");
        strs.add("and");

        remove(strs);
        for (Object o : strs) {
            System.out.println(o);
        }

    }
    public static void remove(ArrayList<String> list){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() % 2 != 0){
                list.remove(i);
            }
        }
    }
}
