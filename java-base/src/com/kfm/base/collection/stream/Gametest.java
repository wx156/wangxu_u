package com.kfm.base.collection.stream;

public class Gametest {
    public static void main(String[] args) {
//        PokerGame pokerGame = new PokerGame();
//        pokerGame.start().forEach(e -> System.out.println(e));
//
//        PokerGame poker = new PokerGame(false);
//        poker.boom(3).forEach(e -> System.out.println(e));

        PokerGame pokerGame1 = new PokerGame(false);
        pokerGame1.ten()
                .forEach(e -> System.out.println(e));
    }
}
