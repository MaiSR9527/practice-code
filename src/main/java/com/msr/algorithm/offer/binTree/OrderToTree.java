package com.msr.algorithm.offer.binTree;

import com.msr.datastructure.binarytree.TreeNode;

/**
 * @description: 根据遍历顺序重建二叉树
 * @author: MaiShuRen
 * @date: 2020/3/12 23:50
 * @version: v1.0
 */

public class OrderToTree {

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序
     * 遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列
     * {4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     */
    public static void main(String[] args) {

    }

    public static TreeNode reBuildBinTree(int[] preOrder, int[] inOrder) {
        return construct(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    /**
     * @param preOrder 前序遍历
     * @param ps       前序遍历的开始位置
     * @param pe       前序遍历的结束位置
     * @param inOrder  中序遍历
     * @param is       中序遍历的开始位置
     * @param ie       中序遍历的结束位置
     * @return
     */
    private static TreeNode construct(int[] preOrder, int ps, int pe, int[] inOrder, int is, int ie) {
        //TODO 重建二叉树
        //开始位置大于结束位置，已经没有要处理的元素了
        if (ps > pe) {
            return null;
        }
        //取前序遍历的第一个数字，就是当前的根节点
        int val = preOrder[ps];
        int index = is;
        //在中序遍历的数组中找出根节点的位置
        while (index <= ie && inOrder[index] != val) {
            index++;
        }
        //如果在整个中序遍历的数组中没有找到，说明输入的参数是不合法的，抛出异常
        if (index > ie) {

        }
        return null;

    }
}
