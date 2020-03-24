package com.msr.datastructure.array;

import java.util.Arrays;

/**
 * @description: 模拟数组
 * @author: MaiShuRen
 * @date: 2020/3/19 11:01
 * @version: v1.0
 */

public class MyArray<E> {

    private E[] data;
    private int size;

    //初始化容量
    public MyArray(int size) {
        this.size = size;
    }

    //空参师，默认容量
    public MyArray() {
        this(10);
    }

    //测试
    public static void main(String[] args) {
        MyArray<Integer> array = new MyArray<>(16);
        array.add(5);
        array.add(6);
        array.add(7);
        array.add(8);
        System.out.println(array.toString());
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new RuntimeException("index out of array length");
        }
        if (data !=null && size == data.length){
            resize(data.length * 2);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public void add(E e) {
        add(size - 1, e);
    }


    //满了扩容
    private void resize(int newCapacity) {
        data = Arrays.copyOf(data, newCapacity);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("index out of array length");
        }
        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    //修改index上的元素
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new RuntimeException("index out of array length");
        }
        data[index] = e;
    }

    //查找是否包含
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //查找元素所在位置
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    //删除index上的元素，并返回删除的元素
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("index out of array length");
        }
        E res = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return res;
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E removeFirst() {
        return remove(0);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(",");
            }
            builder.append("]");
        }
        return builder.toString();
    }

}
