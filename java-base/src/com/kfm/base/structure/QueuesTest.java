package com.kfm.base.structure;

public class QueuesTest {
    public static void main(String[] args) {
        Queues q = new Queues();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);
        q.enqueue(9);
        q.enqueue(10);
        q.enqueue(11);
        System.out.println(q.dequeue());
        System.out.println(q.toString());
        System.out.println(q.dequeue());
        System.out.println(q.toString());
        System.out.println(q.peek());
        System.out.println(q.size());
        System.out.println(q.isEmpty());
    }
}
