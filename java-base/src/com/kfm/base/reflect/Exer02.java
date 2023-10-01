package com.kfm.base.reflect;

import java.util.ArrayList;
import java.util.Collection;

public class Exer02 {
    public static void main(String[] args) {
        getAllclass("com.kfm.base.abnormal");
    }
    public static Collection<Class> getAllclass (String packag){
        ArrayList<Class> arrayList = new ArrayList<>();


        ClassLoader.getSystemResource(packag);
        return arrayList;
    }
}
