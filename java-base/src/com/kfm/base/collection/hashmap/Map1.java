package com.kfm.base.collection.hashmap;

import java.util.HashMap;

public class Map1 {
    public static void main(String[] args) {

        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("河北省","冀");
        hashMap.put("河南省","豫");
        hashMap.put("浙江省","浙");
        hashMap.put("黑龙江省","黑");
        hashMap.put("四川省","川");
        hashMap.put("甘肃省","甘");

        hashMap.keySet().removeIf(value -> value.contains("江"));
        System.out.println(hashMap);
    }
}
