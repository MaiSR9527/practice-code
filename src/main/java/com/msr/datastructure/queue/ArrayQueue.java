package com.msr.datastructure.queue;

import java.util.Arrays;

/**
 * @description: 使用数组创建一个队列
 * @author: MaiShuRen
 * @date: 2020/3/1 18:50
 * @version: v1.0
 */

public class ArrayQueue<E> {
    //最大容量
    private int maxSize;
    //队列头
    private int front;
    //队列尾
    private int rear;
    //存储数据
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            throw new RuntimeException("queue is full");
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        front++;
        return arr[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("queue is empty,can not show");
        }
        Arrays.stream(arr).forEach(System.out::println);
    }

    public int head() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return arr[front + 1];
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.addQueue(1);
        queue.addQueue(2);
        queue.addQueue(3);
        int queue1 = queue.getQueue();
        int queue2 = queue.getQueue();
        System.out.println(queue1+" "+queue2);
        queue.showQueue();
    }
}
