package com.kfm.base.collection.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PokerGame {
    //牌堆对象不可见
    private Poker poker = new Poker();

    public PokerGame() {
    }

    /**
     * 传参构造，确认游戏是否有王（默认为true为有王，传入false则牌堆没有王）
     *
     * @param hasJoker
     */
    public PokerGame(boolean hasJoker) {
        if (hasJoker) {
            poker = new Poker();
        } else {
            poker = new Poker(false);
        }
    }

    /**
     * 斗地主 有三个用户牌堆和一个底牌堆
     *
     * @return 返回的是用户可见内容 即返回字符串，返回对象的话只能返回地址
     */
    public List<List<String>> start() {

        List<Poker.Card> face = this.poker.getPokers();
        for (int i = 0; i < 3; i++) {
            Collections.shuffle(face);
        }

        /*
           三个用户牌堆和一个底牌牌堆
         */
        List<Poker.Card> p1 = new ArrayList<>();
        List<Poker.Card> p2 = new ArrayList<>();
        List<Poker.Card> p3 = new ArrayList<>();
        //底牌元素只有三个，存在list集合中，可以按索引存取，将最后的三个加入底牌堆，转换成string集合
        List<String> bo = List.of(face.get(51).getString(), face.get(52).getString(), face.get(53).getString());
        /*
        为牌堆对象添加元素
         */
        for (int count = 0, i = 0; count < 17; count++) {
            p1.add(face.get(i++));
            p2.add(face.get(i++));
            p3.add(face.get(i++));
        }
        /*
            将每个用户的手牌排序后转换为string集合
         */
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

        /*
            将每个string集合 整合 并返回
         */
        List<List<String>> result = List.of(pr1, pr2, pr3, bo);
        return result;
    }

    /**
     * 炸金花游戏
     * @return
     */
    public List<List<String>> boom (int n) {
        if (n < 2 || n > 17) {
            throw new RuntimeException("人数不够");
        }
        //传入hasJoker为false （炸金花不需要大小王）

        List<Poker.Card> p1 = poker.getPokers();


        for (int i = 0; i < 3; i++) {
            Collections.shuffle(p1);
        }

        List<List<String>> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            List<Poker.Card> p = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                p.add(p1.get(count++));
            }
            List<String> ps = p.stream()
                    .sorted()
                    .map(e -> e.getString())
                    .collect(Collectors.toList());
            list.add(ps);
        }
        return list;
    }
}

/**
 * poker类存储牌堆对象，每 new 一个 poker 对象都是一个新的牌堆（poker构造不能写static）
 * poker类
 */
class Poker {
    // 花色
    private static final List<String> color = List.of("♠", "♥", "♣", "♦");
    // 点数
    private static final List<String> points = List.of("2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4",
            "3");

    //一个只能存card对象的pokers集合（存为card 后可以根据order排序）
    private List<Card> pokers;

    //默认为hasJoker为true
    public Poker() {
        this(true);
    }

    /*
        hasJoker的牌堆是不一样的，根据传入的hasJoker创建不同的牌堆
     */
    public Poker(boolean hasJoker) {
        pokers = new ArrayList<>();
        for (int i = 0; i < color.size(); i++) {
            for (int j = 0; j < points.size(); j++) {
                pokers.add(new Card(color.get(i), points.get(j), 4 * j + i + j + 2));
            }
        }
        if (hasJoker) {
            pokers.add(new Card(null, "大王", 0));
            pokers.add(new Card(null, "小王", 1));
        }
    }

    public List<Card> getPokers() {
        return pokers;
    }

    public void setPokers(List<Card> pokers) {
        this.pokers = pokers;
    }

    /**
     * \
     * <p>
     * Card用来存每一张扑克牌 card 基于poker，比 poker 多一个字段用于实现比较
     */
    class Card implements Comparable<Card> {
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

        /*
            用户看到的是string而不是对象地址
         */
        public String getString() {
            return color == null ? point : color + point;
        }

        @Override
        public int compareTo(Card o) {
            return this.order - o.order;
        }
    }

}
