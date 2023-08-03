package com.kfm.base.structure;

public class StarksTest {
    public static void main(String[] args) {
        Starks s = new Starks();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        s.push(8);
        s.push(9);
        s.push(10);
        s.push(11);
        s.push(12);
        s.push(13);
        s.push(14);
        s.push(15);
        s.push(16);
        s.push(17);
        s.push(18);
        s.push(19);
        s.push(20);
        s.push(21);
        s.push(22);


        System.out.println(s.peek());

        System.out.println(s.toString());
        System.out.println(s.pop());
        System.out.println(s.toString());
        System.out.println(s.isEmpty());
        System.out.println(s.size());
    }
}
