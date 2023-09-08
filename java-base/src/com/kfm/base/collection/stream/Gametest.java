package com.kfm.base.collection.stream;

public class Gametest {
    public static void main(String[] args) {
        PokerGame pokerGame = new PokerGame();
        pokerGame.start().forEach(e -> System.out.println(e));
    }
}
