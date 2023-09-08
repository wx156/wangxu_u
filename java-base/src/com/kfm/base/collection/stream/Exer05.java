package com.kfm.base.collection.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exer05 {
    static List<String> flower = new ArrayList<>(List.of("♠","♣","♥","♦"));



    static List<String> points = new ArrayList<>(List.of("2","A","K","Q","J","10","9","8","7","6","5","4","3"));

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

        for (int count = 0 , i = 0; count < 17; count++) {
            player1.add(poker.get(i++));
            player2.add(poker.get(i++));
            player3.add(poker.get(i++));
        }
        bottom.add(poker.get(51));
        bottom.add(poker.get(52));
        bottom.add(poker.get(53));





        player1.stream().sorted().forEach(e -> System.out.print(e + " "));
        System.out.println();
        player2.stream().sorted().forEach(e -> System.out.print(e + " "));
        System.out.println();
        player3.stream().sorted().forEach(e -> System.out.print(e + " "));
        System.out.println();
        bottom.stream().sorted().forEach(e -> System.out.print(e + " "));
    }

}
