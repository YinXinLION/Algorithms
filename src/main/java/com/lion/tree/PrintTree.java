package com.lion.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 前序、中序、后序 遍历二叉树
 * 遍历 时间复杂度O(n)
 */
public class PrintTree {
    public static void preOrder(Node root) {
        if (root == null) {
           return;
        }
        System.out.println(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

    void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }

    void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }

    // 二叉树按层遍历
    public static void levelOrder(Node root) {
        List<Node> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            Node node = ((LinkedList<Node>) list).pollFirst();
            System.out.println(node.value);
            if (node.left != null) {
                list.add(node.left);
            }
            if (node.right != null) {
                list.add(node.right);
            }
        }
    }

    class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
