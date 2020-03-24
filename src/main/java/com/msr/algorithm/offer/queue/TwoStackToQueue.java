package com.msr.algorithm.offer.queue;

import java.util.Stack;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/3/13 09:09
 * @version: v1.0
 */

public class TwoStackToQueue {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    /**
     * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     */
    public static void main(String[] args) {
        TwoStackToQueue queue = new TwoStackToQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

    public void push(int val){
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(val);
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }

    public int pop(){
        return stack2.pop();
    }
}
