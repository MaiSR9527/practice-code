package com.msr.datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 构建一个二叉树
 * @author: MaiShuRen
 * @date: 2020/3/8 16:09
 * @version: v1.0
 */

public class BuildBinaryTree {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        BuildBinaryTree binaryTree = new BuildBinaryTree();
        List<TreeNode> tree = binaryTree.createBinaryTree(arr);
        System.out.println("前序遍历");
        binaryTree.preOrderTraverse(tree.get(0));
        System.out.println("中序遍历");
        binaryTree.inOrderTraverse(tree.get(0));
        System.out.println("后序遍历");
        binaryTree.postOrderTraverse(tree.get(0));

    }

    /**
     * 前序遍历
     *
     * @param treeNode
     */
    public void preOrderTraverse(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.key + " ");
        preOrderTraverse(treeNode.left);
        preOrderTraverse(treeNode.right);
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public void inOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.left);
        System.out.print(node.key + " ");
        inOrderTraverse(node.right);
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public void postOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.left);
        inOrderTraverse(node.right);
        System.out.print(node.key + " ");
    }

    /**
     * 构建二叉树
     *
     * @param array
     * @return
     */
    public List<TreeNode> createBinaryTree(int[] array) {
        List<TreeNode> nodeList = new ArrayList<>();
        for (int i : array) {
            nodeList.add(new TreeNode(i));
        }

        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            //左孩子
            nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
            //右孩子
            nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
        }

        //最后一个节点可能存在没有右孩子的情况，所以拿出来单独处理
        int lastParentIndex = array.length / 2 - 1;
        //左孩子
        nodeList.get(lastParentIndex).left = nodeList.get(lastParentIndex * 2 + 1);
        //右孩子，如果长度为奇数则建立有孩子
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex * 2 + 2);
        }
        return nodeList;

    }
}
