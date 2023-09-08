package com.kfm.base.collection.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PokerGame {
    private Poker poker = new Poker();

    public List<List<String>> start(){
        List<Poker.Card> face = this.poker.getPokers();
        Collections.shuffle(face);

        List<Poker.Card> p1 = new ArrayList<>();
        List<Poker.Card> p2 = new ArrayList<>();
        List<Poker.Card> p3 = new ArrayList<>();
        List<String> bo = List.of(face.get(51).getString(),face.get(52).getString(),face.get(53).getString());

        for (int count = 0, i = 0; count < 17;count++) {
            p1.add(face.get(i ++));
            p2.add(face.get(i ++));
            p3.add(face.get(i ++));
        }
        List<String> pr1 = p1.stream()
                .sorted()
                .map(e -> e.getString())
                .collect(Collectors.toList());
        List<String> pr2 = p2.stream()
                .sorted()
                .map(e -> e.getString())
                .collect(Collectors.toList());
        List<String> pr3 = p3.stream()
                .sorted()
                .map(e -> e.getString())
                .collect(Collectors.toList());
        List<List<String>> result = List.of(pr1,pr2,pr3,bo);
        return result;
    }
}

/**
 * poker类
 */
class Poker {
    // 花色
    private static final List<String> color = List.of("♠", "♥", "♣", "♦");
    // 点数
    private static final List<String> points = List.of("2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");

    private List<Card> pokers;

    public Poker() {
        pokers = new ArrayList<>();
        for (int i = 0; i < color.size(); i++) {
            for (int j = 0; j < points.size(); j++) {
                pokers.add(new Card(color.get(i), points.get(j), 4 * j + i + j + 2));
            }
        }
        pokers.add(new Card(null,"大王",0));
        pokers.add(new Card(null,"小王",1));
    }

    public List<Card> getPokers() {
        return pokers;
    }

    public void setPokers(List<Card> pokers) {
        this.pokers = pokers;
    }

    /**\
     *
     * Card用来存每一张扑克牌 card 基于poker，比 poker 多一个字段用于实现比较
     */
    class Card implements Comparable<Card>{
        private String color;
        private String point;
        private Integer order;

        public Card(String color, String point, Integer order) {
            this.color = color;
            this.point = point;
            this.order = order;
        }

        public Integer getOrder() {
            return this.order;
        }

        public String getString() {
            return color == null ? point : color + point;
        }

        @Override
        public int compareTo(Card o) {
            return this.order - o.order;
        }
    }

}
