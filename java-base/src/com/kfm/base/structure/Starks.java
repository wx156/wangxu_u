package com.kfm.base.structure;

public class Starks extends Stack{
    static private Object [] arr = new Object[10];
    static private int count = 0;
    //进栈
    public void push(Object obj){
        if (count + 1 > arr.length) {
            grow();
        }
        arr[count ++] = obj;
    }
    //出栈
    public Object pop(){
        if (count == 0){
            return null;
        }
        Object a = arr[count-1];
        arr[--count] = null;
        return a;
    }
    //返回栈首元素
    public Object peek(){
        return arr[count-1];
    }
    //扩容
    private void grow() {
        Object [] newArr = new Object[arr.length+arr.length/2];
        if (newArr.length < arr.length){
            Object []newArr1 = new Object[Integer.MAX_VALUE];
            arr = newArr1;
        }
        System.arraycopy(arr,0,newArr,0,count);
        arr = newArr;
    }
    //栈是否为空
    public boolean isEmpty(){
        if (count == 0){
            return true;
        }
        return false;
    }
    //栈内的元素个数
    public int size(){
        return count;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < count-1; i++) {
            sb.append(arr[i] + ",");
        }
        sb.append(arr[count-1]).append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return (this == obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
