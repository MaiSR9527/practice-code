package com.msr.algorithm.offer.linkList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @description: 反转链表
 * @author: MaiShuRen
 * @date: 2020/2/21 15:28
 * @version: v1.0
 */

public class TailToHeadPrintLinkList {

    public static void main(String[] args) {
        ListNode test = new ListNode(0);
        ListNode test2 = new ListNode(1);
        ListNode test3 = new ListNode(2);
        ListNode test4 = new ListNode(3);
        test.next = test2;
        test2.next = test3;
        test3.next = test4;
        TailToHeadPrintLinkList tail = new TailToHeadPrintLinkList();
        ArrayList<Integer> reverse = tail.reverse(test);
        Arrays.stream(reverse.toArray()).forEach(System.out::print);

    }

    /**
     * 输入一个链表的头结点，按照 从尾到头 的顺序返回节点的值。
     * <p>
     * 返回的结果用数组存储。
     */
    public ArrayList<Integer> reverse(ListNode listNode) {
        //利用栈完成
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<ListNode> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode);
            listNode = listNode.next;
        }
        ListNode temp;
        while (!stack.isEmpty()) {
            temp = stack.pop();
            arrayList.add(temp.val);
        }
        return arrayList;
    }
}

//链表
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
