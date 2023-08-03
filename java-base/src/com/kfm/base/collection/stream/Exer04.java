package com.kfm.base.collection.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.ToDoubleFunction;

public class Exer04 {
    public static void main(String[] args) {
        int [] arr = {2,3,5,6,8,4};
        int sum = 0;
        ArrayList<Double> arrlist = new ArrayList();
        Arrays.stream(arr).forEach((e) -> arrlist.add(Math.pow(e,2)));


        Double d = arrlist.stream().mapToDouble(new ToDoubleFunction<Double>() {
            @Override
            public double applyAsDouble(Double value) {
                return value;
            }
        })

                .sum()/arrlist.size();
        System.out.println(d);

    }
}
