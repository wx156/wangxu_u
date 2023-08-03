package com.kfm.base.collection.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exer01 {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> hashMap = new LinkedHashMap<>();
        hashMap.put("a",4);
        hashMap.put("b",3);
        hashMap.put("c",2);
        hashMap.put("d",1);


//        LinkedHashMap linkedHashMap = hashMap;
//        linkedHashMap.compute("a",(k , v) ->{
//            return null;
//        });
//        Integer a = hashMap.computeIfAbsent("a", (v) -> {
//            return null;
//        });
//        System.out.println(a);


        ArrayList<String> man = new ArrayList<>();
        man.add("张三丰");
        man.add("张无忌");
        man.add("张三");

        ArrayList<String> women = new ArrayList<>();
        women.add("赵敏");
        women.add("赵四");
        women.add("张曼玉");

        Stream<String> a = Stream.concat(man.stream().distinct(),women.stream().distinct());
        ArrayList<String> s = new ArrayList();
        s.add(Arrays.toString(a.collect(Collectors.toList()).stream().toArray()));


        s.stream().filter((e) -> e.length() >= 3).forEach((e) -> System.out.println(e));
    }
}
