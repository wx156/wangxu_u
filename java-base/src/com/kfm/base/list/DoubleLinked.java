package com.kfm.base.list;

import java.util.AbstractList;

public class DoubleLinked extends AbstractList {
    /*
        头节点
     */
    private Node first;


    /*
       尾节点
     */
    private Node last;

    /*
        节点个数
     */
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        Node c = new Node(last, o, null);
        if (first == null) {
            first = c;
        } else {
//            Node c = first;
//
//            // 找最后一个 节点
//            while (c.next != null){
//                c = c.next;
//            }

            last.next = c;
        }

        last = c;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        // 没有元素
        if (first == null){
            return false;
        }
        if (first.valueEquals(o)){ // 是否是头节点
            // 删除头节点
            Node old = first;
            if (first.next != null){
                first.next.prev = null;
            }

            first = old.next;

            old.next = null;
        } else {
            Node c = first.next;

            while (c != null && !c.valueEquals(o)){
                c = c.next;
            }

            if (c != null){ // 删除元素
                if (last.valueEquals(o)){
                    // 删除最后一个
                    last = last.prev;

                    last.next.prev = null;
                    last.next = null;
                } else {
                    c.prev.next = c.next;
                    c.next.prev = c.prev;

                    c.prev = null;
                    c.next = null;
                }
            }
        }

        size --;
        return true;
    }

    @Override
    public void clear() {
        first = last = null;
        size = 0;
    }

    @Override
    public Object get(int index) {
        Node node = getNode(index);
        return node.value;
    }

    private Node getNode(int index){
        if (index >= 0 && index < size){

            Node point = first; // 头
            if (index >= size / 2){
                point = last; // 尾
                for (int i = 0; i < size - index - 1; i++) {
                    point = point.prev;
                }

            } else {
                // i = 0; i < index
                for (int i = index -1; i >= 0; i--) {
                    point = point.next;
                }
            }

            return point;

        }
        throw new IndexOutOfBoundsException("下标越界： " + index);
    }

    @Override
    public Object set(int index, Object element) {
        if (index >= 0 && index < size) {
            // index 合法
            Node node = getNode(index);
            Object old = node.value;
            node.value = element;
            return old;
        }

        throw new IndexOutOfBoundsException();
    }

    @Override
    public void add(int index, Object element) {
        // TODO checkIndex
        if (index == size){
            add(element);
        } else if (index == 0) {

        } else {

        }
    }

    @Override
    public Object remove(int index) {
        Object old = null;
        if (index == 0){
            // 删头节点
            if (first == last){
                // 只有一个元素
                old = first.value;
                first = last = null;

            } else {
                // 如果有多个
                first = first.next;

//                Node oldFirst = first.prev; // 旧的头节点
//
//                oldFirst.next = null;
//                old = oldFirst.value;
//                first.prev = null;

                first.prev.next = null;
                old = first.prev.value;
                first.prev = null;
            }
        } else if (index == size - 1) {
            // 删除尾结点
            last = last.prev;

            Node oldLast = last.next;
            oldLast.prev = null;
            old = oldLast.value;
            last.next = null;
        } else {
            Node node = getNode(index);

            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.next = null;
            node.prev = null;

            old = node.value;
        }

        size --;
        return old;
    }

    @Override
    public int indexOf(Object o) {
        Node c = first;
        int index = 0;

        while (c != null){
            if (c.valueEquals(o)){
                return index;
            }
            c = c.next;
            index ++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        Node c = first;
        while (c != null) {
            sb.append(c.value);
            if (c.next != null) {
                sb.append(", ");
            }
            c = c.next;
        }

        sb.append(" }");
        return sb.toString();
    }


    private class Node {
        /*
            前一个节点
         */
        private Node prev;

        /**
         * 值
         */
        private Object value;


        /**
         * 下一个节点
         */
        private Node next;

        public Node(Node prev, Object value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }

        public boolean valueEquals(Object value){
            if (this.value == null){
                return this.value == value;
            } else {
                return this.value.equals(value);
            }
        }
    }
}
