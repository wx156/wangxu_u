package com.kfm.base.structure;

public class Queues extends Queue {
    static private Object[] arr = new Object[10];
    static private int count = 0;

    //入队
    public void enqueue(Object obj) {
        if (count + 1 > arr.length) {
            grow();
        }
        arr[count++] = obj;
    }

    //出队
    public Object dequeue() {
        if (count == 0) {
            return null;
        }
        Object a = arr[0];
        count--;
        System.arraycopy(arr, 1, arr, 0, count);
        arr[count] = null;
        return a;
    }

    public int size() {
        return count;
    }

    //队列是否为空
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        return false;
    }

    //返回队首元素
    public Object peek() {
        return arr[0];
    }

    //扩容
    private void grow() {
        Object[] newArr = new Object[arr.length + arr.length / 2];
        if (newArr.length < arr.length){
            Object []newArr1 = new Object[Integer.MAX_VALUE];
            arr = newArr1;
        }
        System.arraycopy(arr, 0, newArr, 0, count);
        arr = newArr;
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < count - 1; i++) {
            sb.append(arr[i] + ",");
        }
        sb.append(arr[count - 1]).append("]");
        return sb.toString();
    }

}
