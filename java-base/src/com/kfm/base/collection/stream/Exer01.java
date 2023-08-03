package com.kfm.base.collection.stream;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Exer01 {
    public static void main(String[] args) {
        String[] arr = {"a", "b", "c"};

        String str = Arrays.stream(arr).collect(Collectors.joining());

        System.out.println(str);
    }
}
