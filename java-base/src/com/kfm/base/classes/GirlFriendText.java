package com.kfm.base.classes;

public class GirlFriendText {


    public static void main(String[] args) {
        GirlFriend fengjie = new GirlFriend();

        String a = fengjie.cook();
        String b = fengjie.wash();
        fengjie.name = "凤姐";
        fengjie.stature = 155.0;
        fengjie.weight = 130.0;
        System.out.println(a);
        System.out.println(b);
        fengjie.show();
    }
}
