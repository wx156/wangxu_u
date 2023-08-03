package com.kfm.base.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Linked implements List {
    /*
       链表的头节点
       第一个元素
    */
    private Node first;

    /*
    元素个数
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
        Node c  = first;
        for (int i = 0; i < size; i++) {
            if (new Node(o,null).equals(c.value)){//表示找到了
                return true;
            }
            c =c.next;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Node c = first;
        Object obj [] = new Object[size];
        for (int i = 0; i < size; i++) {
            obj[i] = c.value;
            c = c.next;
        }

        return obj;
    }

    @Override
    public boolean add(Object obj) {
        /*
           Object --> Node
         */
        Node current = new Node(obj, null); // 当前要添加的 节点
        if (first == null) {
            first = current;
        } else {
            // 有元素， 遍历链表找到最后一个节点
            Node c = first; // 当前遍历的 节点

            while (c.next != null) {
                c = c.next;
            }
            // 此时 c 是最后一个元素
            c.next = current;
        }

        size ++; // 数量 + 1
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node before = first;
        Node c = first.next;
        if (new Node(o,null).equals(first)){
            first = first.next;
            first.next = null;
            size--;
        }else {
            for (int i = 1; i < size; i++) {
                if (new Node(o,null).value.equals(c.value)){
                    before.next = c.next;
                    c.next = null;
                    size--;
                    return true;
                }
                before = c;
                c = c.next;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    @Override
    public Object get(int index) {
        Node c = first;
        Object o = null;
        for (int i = 0; i < size; i++) {
            if (i == index){
                o = c.value;
            }
            c = c.next;
        }
        return o;
    }

    @Override
    public Object set(int index, Object element) {
        Node c = first;
        Object o = null;
        for (int i = 0; i <= index; i++) {
            if (i == index){
                o = c.value;
                c.value = element;
            }
            c = c.next;
        }
        return o;
    }

    @Override
    public void add(int index, Object element) {
        if (index < 0 || index>size){
            throw new LinkedIndexOutOfBounds("下标不合法");
        }else {
            if (index == 0) {
                first = new Node(element,first);
                size++;
            }else if (index == size){
                Node c = first;
                for (int i = 0; i < size; i++) {
                    if (c.next == null){
                        c.next = new Node(element,null);
                        size++;
                        break;
                    }
                    c = c.next;
                }
            }else {
                Node pre = first;
                Node c = first.next;
                for (int i = 1; i <= index; i++) {
                    if (i == index){
                        pre.next = new Node(element,c);
                        c = pre.next.next;
                        size++;
                    }
                    pre = c;
                    c = c.next;
                }
            }
        }
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index > size-1){
            throw new LinkedIndexOutOfBounds("下标不合法");
        }
        Node c = first;
        Object old = null;
        for (int i = 0; i <= index; i++) {
            if (i == index){
                old = c.value;
                remove(old);
            }
            c = c.next;
        }
        return old;
    }

    @Override
    public int indexOf(Object o) {
        Node c = first;
        for (int i = 0; i < size; i++) {

            if (new Node(o,null).value.equals(c.value)){
                return i;
            }
            c = c.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {

        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public String toString(){
        StringBuilder st = new StringBuilder();
        if (first == null){
            return "Linked[]";
        }else {

            Node c = first;
            st.append("Linked[");
            while (c.next != null) {
                st.append(c.value);
                c = c.next;
                st.append(", ");
            }
            st.append(c.value);
            st.append("]");
        }
        return st.toString();
    }

    /**
     * 链表中的 节点对象
     */
    private class Node {
        /*
            元素的值
         */
        private Object value;

        /**
         * 下一个 节点
         */
        private Node next;

        public Node(Object value, Node next) {
            this.value = value;
            this.next = next;
        }
        /**
         * 判断 node 节点是否一样
         *  node 的值是否一样
         * @param obj
         * @return
         */
        @Override
        public boolean equals(Object obj){
            if (obj == null){
                return false;
            }

            if (obj == this){
                return true;
            }

            if (obj instanceof Node node){
                if (this.value == null){
                    return node.value == null;
                } else {
                    return value.equals(node.value);
                }
            }
            return false;
        }
    }

    class LinkedIndexOutOfBounds extends RuntimeException{
        private LinkedIndexOutOfBounds(){
            super();
        }
        private LinkedIndexOutOfBounds(String message){
            super(message);
        }
    }
}
