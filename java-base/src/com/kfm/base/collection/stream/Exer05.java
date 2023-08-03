package com.kfm.base.collection.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exer05 {
    static List<String> flower = new ArrayList<>(List.of("♠","♣","♥","♦"));



    static List<String> points = new ArrayList<>(List.of("A","2","3","4","5","6","7","8","9","10","J","Q","K"));

    static List<String> poker = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < flower.size(); i++) {
            for (int j = 0; j < points.size(); j++) {
                poker.add(flower.get(i)+points.get(j));
            }
        }
        poker.add("大王");
        poker.add("小王");


        List<String> player1 = new ArrayList<>(); // 玩家一
        List<String> player2 = new ArrayList<>(); // 玩家二
        List<String> player3 = new ArrayList<>(); // 玩家三
        List<String> bottom = new ArrayList<>(); // 底牌


        Collections.shuffle(poker);

        player1.addAll(poker.subList(0,17));
        player2.addAll(poker.subList(17,34));
        player3.addAll(poker.subList(34,51));

        bottom.addAll(poker.subList(51,54));

        player1.stream().sorted().forEach(e -> System.out.print(e + " "));
        System.out.println();
        player2.stream().sorted().forEach(e -> System.out.print(e + " "));
        System.out.println();
        player3.stream().sorted().forEach(e -> System.out.print(e + " "));
        System.out.println();
        bottom.stream().sorted().forEach(e -> System.out.print(e + " "));
    }

}
