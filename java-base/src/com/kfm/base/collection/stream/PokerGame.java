package com.kfm.base.collection.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokerGame {
    //牌堆对象不可见
    private Poker poker = new Poker();

    private Poker1 poker1 = new Poker1();

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
     *
     * @return
     */
    public List<List<String>> boom(int n) {
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

    /**
     * 十点半游戏
     */
    public List<List<String>> ten() {
        Scanner inpu = new Scanner(System.in);
        List<Poker1.Card> p = poker1.getPokers();

        for (int i = 0; i < 3; i++) {
            Collections.shuffle(p);
        }
        List<List<String>> list = new ArrayList<>();

        List<Poker1.Card> pc = new ArrayList<>();
        List<Poker1.Card> pl = new ArrayList<>();

        pl.add(p.get(0));
        pc.add(p.get(1));
        int sum = 0;
        pl.stream().map(e -> e.getString()).forEach(e -> System.out.println(e));
        int result = -1;
        int index = 2;
        boolean flag = false;
        while (result != 0 || pl.stream().mapToDouble(e -> e.getValue()).sum() * 10 >= 105) {
            if (result != 0) {
                System.out.println("请决定要不要牌（要牌请输入1，不要请输入0）");
                result = inpu.nextInt();
            } else {
                break;
            }
            while (result != 0 && result != 1) {
                System.out.println("请输入正确的请求");
                result = inpu.nextInt();
                break;
            }
            for (int i = index; i < p.size(); i++) {
                if (result == 1) {
                    pl.add(p.get(i));
                    sum = pl.stream().mapToInt(e -> e.getValue()).sum();
                    break;
                }
            }
            index++;
            System.out.println(pl.stream().map(e -> e.getString()).collect(Collectors.joining()));
            if (pl.size() == 5){
                flag = true;
                break;
            }
            if (sum == 105) {
                System.out.println("你不需要再加牌了");
                break;
            } else if (sum > 105) {
                System.out.println("You're dead already");
                break;
            }


        }
        if (flag && pl.stream().mapToInt(e -> e.getValue()).sum() <= 105){
            System.out.println("玩家赢了");
        }else {
            for (int i = index; i < p.size(); i++) {
                if (sum > 105) {
                    flag = false;
                } else if (pc.stream().mapToInt(e -> e.getValue()).sum() < sum) {
                    pc.add(p.get(i));
                    if (pc.stream().mapToInt(e -> e.getValue()).sum() > 105 && sum <= 105) {
                        flag = true;
                    } else if (pc.stream().mapToInt(e -> e.getValue()).sum() <= 105 && pc.stream().mapToInt(e -> e.getValue()).sum() >= sum &&
                    pc.stream().mapToInt(e -> e.getValue()).sum() <= 105) {
                        flag = false;
                    } else {
                        flag = true;
                    }
                } else {
                    flag = false;
                }
                index++;
            }

            if (flag) {
                System.out.println("玩家赢了");
            } else {
                System.out.println("电脑赢了");
            }
            List<String> pl1 = pl.stream().map(e -> e.getString()).collect(Collectors.toList());
            list.add(pl1);
            list.add(pc.stream().map(e -> e.getString()).collect(Collectors.toList()));
        }
        return list;
    }


    /**
     * 十点半游戏的类
     */
    class Poker1 {
        private static final List<String> color = List.of("♠", "♥", "♣", "♦");
        // 点数
        private static final List<String> points = List.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q"
                , "K");

        private List<Card> pokers;

        //默认为hasJoker为true
        public Poker1() {
            this(true);
        }

        /*
            hasJoker的牌堆是不一样的，根据传入的hasJoker创建不同的牌堆
         */
        public Poker1(boolean hasJoker) {
            pokers = new ArrayList<>();
            for (int i = 0; i < color.size(); i++) {
                for (int j = 0; j < points.size() - 3; j++) {
                    pokers.add(new Card(color.get(i), points.get(j), 4 * j + i + j, (j + 1) * 10));
                }
                for (int j = 10; j < points.size(); j++) {
                    pokers.add(new Card(color.get(i), points.get(j), 4 * j + i + j, 5));
                }
            }
            if (hasJoker) {
                pokers.add(new Card(null, "大王", 0, 5));
                pokers.add(new Card(null, "小王", 1, 5));
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

            private Integer value;

            public Card(String color, String point, Integer order) {
                this.color = color;
                this.point = point;
                this.order = order;
            }

            public Card(String color, String point, Integer order, Integer value) {
                this.color = color;
                this.point = point;
                this.value = value;
                this.order = order;
            }

            public Integer getValue() {
                return value;
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

            private Double value;

            public Card(String color, String point, Integer order) {
                this.color = color;
                this.point = point;
                this.order = order;
            }

            public Card(String color, String point, Double value) {
                this.color = color;
                this.point = point;
                this.value = value;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public String getPoint() {
                return point;
            }

            public void setPoint(String point) {
                this.point = point;
            }

            public void setOrder(Integer order) {
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

}
