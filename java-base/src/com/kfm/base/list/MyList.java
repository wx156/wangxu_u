package com.kfm.base.list;

import java.util.*;

public class MyList implements List {
    // 存元素的数组
    private Object[] value;

    // 下一个元素的下标， 元素个数
    private int size;

    // 每次增长量
    private int increment;

    // 默认长度
    private static final int DEFAULT_CAPACITY = 5;

    // 默认增长量
    private static final int DEFAULT_INCREMENT = 10;


    public MyList(){
        // 调用
        this(DEFAULT_CAPACITY, DEFAULT_INCREMENT); // this(5, 10); --> MyList(int, int)
//         this([参数列表]);
    }

    public MyList(int capacity){
        this(capacity, DEFAULT_INCREMENT);
    }

    public MyList(int capacity, int increment){
        if (capacity < 0 ){
            capacity = DEFAULT_CAPACITY;
        }
        if (increment <= 0){
            increment = DEFAULT_INCREMENT;
        }
        // 初始化字段
        this.value = new Object[capacity];
        this.increment = increment;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 判断是否包含
     * @param o 要判断是否包含的object
     * @return 返回ture代表value数组中有，返回false代表value数组中没有
     */
    @Override
    public boolean contains(Object o) {
        if (o == null){     //判断传入的数据是否是特殊值null，如果为null则用 == 判断
            for (int i = 0; i < size; i++) {
                if (value[i] == o){
                    return true;
                }
            }
            return false;
        }
        for (int i = 0; i < size; i++) {  //如果不为null则用equals比较
            if (value[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    /**
     * 将value转换为数组并返回一个数组
     * @return 数组
     */
    @Override
    public Object[] toArray() {
        Object obj[] = new Object[size];
        obj = Arrays.copyOf(value,size);
        return obj;
    }

    /**
     * 添加元素
     * @param o 要添加的元素
     * @return true 表示添加成功，false 表示添加失败
     */
    @Override
    public boolean add(Object o) {
        grow(size + 1);

        // 存元素
        value[size] = o;
        size ++;
        return true;
    }

    /**
     * 扩容
     * @param minCapacity 所需大小
     */
    private void grow(int minCapacity) {
        // 所需空间 大于 总长度
        if (minCapacity > value.length){
            // 扩容
            int old = value.length;
            int newLength = old + increment;

            // 把元素复制到新数组中
            value = Arrays.copyOf(value, newLength);
        }
    }

    /**
     * 删除元素
     * @param o 要删除的元素
     * @return 返回false代表没有找到或者删除失败，返回true代表删除成功
     */
    @Override
    public boolean remove(Object o) {
        Object obj []= new Object[size -1];
        if (indexOf(o) == -1){
            return false;
        }else if (indexOf(o) ==0){
            System.arraycopy(value,1,obj,0,size-1);
            size--;
            value = obj;
            return true;
        }else if (indexOf(o) == size-1){
            System.arraycopy(value,0,obj,0,size-1);
            size--;
            value = obj;
            return true;
        }else {
            System.arraycopy(value,0,obj,0,indexOf(o));
            System.arraycopy(value,indexOf(o)+1,obj,indexOf(o),size-indexOf(o)-1);
            size--;
            value = obj;
            return true;
        }

    }

    /**
     * 重新格式化容器
     */
    @Override
    public void clear() {
        value = null;
        size = 0;
    }

    /**
     *得到数组中传入下标所对应的元素
     * @param index 想要获取到的元素的下标
     * @return 没找到则返回null，找到则返回该下标所对应的元素
     */
    @Override
    public Object get(int index) {
        if (index >= size || index < 0){
            return null;
        }
        for (int i = 0; i < size; i++) {
            if (i == index){
                return value[i];
            }
        }
        return null;
    }

    /**
     * 将指定位置的元素替换为制定的元素
     * @param index 要替换的元素下标
     * @param element 要替换成的元素
     * @return 返回替换后的容器数组
     */
    @Override
    public Object set(int index, Object element) {
        for (int i = 0; i < size; i++) {
            if (index == i){
                value[i] = element;
            }
        }
        return toArray();
    }


    /**
     * 将指定元素添加到指定位置，若该位置有元素，则包括该位置的元素和该位置后面的元素都后移一位
     * @param index 要添加到的索引
     * @param element 要添加的元素
     */
    @Override
    public void add(int index, Object element) {
        Object obj [] = new Object[size +1];
        if (index > size || index < 0){
            return;
        }else if (index ==0){
            System.arraycopy(value,0,obj,1,size);
            obj[0] = element;
            size++;
            value = obj;
        }else if (index == size){
            System.arraycopy(value,0,obj,0,size);
            obj[size] = element;
            size++;
            value = obj;
        }else {
            System.arraycopy(value,0,obj,0,index);
            System.arraycopy(value,index,obj,index+1,size-index);
            obj[index] = element;
            value = obj;
        }
    }

    /**
     * 删除指定位置的元素，返回从列表中删除的元素
     * @param index 要删除的元素索引
     * @return 返回已删除的元素
     */

    @Override
    public Object remove(int index) {
        Object obj = new Object();
        Object objs [] = new Object[size-1];
        for (int i = 0; i < size; i++) {
            if (index == i) {
                obj = value[i];
                remove(obj);
                break;
            }
        }
        return obj;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (value[i] == null){ // 当前元素是 null
                if (null == o){ // o == null
                    return i;
                }
            }else {
                if (value[i].equals(o)){
                    return i;
                }
            }
        }
        return -1;

    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size -1; i >= 0; i--) {
            if (value[i] == null){ // 当前元素是 null
                if (null == o){ // o == null
                    return i;
                }
            }else {
                if (value[i].equals(o)){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    // --------------------------------------------------


    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
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
    public Iterator iterator() {
        return null;
    }
}