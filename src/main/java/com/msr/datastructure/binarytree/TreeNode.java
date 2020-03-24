package com.msr.datastructure.binarytree;

/**
 * @description: 二叉树
 * @author: MaiShuRen
 * @date: 2020/3/8 16:07
 * @version: v1.0
 */

public class TreeNode {
    int key;
    TreeNode left;
    TreeNode right;

    public TreeNode(int key) {
        this.key = key;
        left = null;
        right = null;
    }
}
