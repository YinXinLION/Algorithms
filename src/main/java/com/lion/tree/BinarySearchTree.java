package com.lion.tree;

/**
 * 二叉查找树
 */
public class BinarySearchTree {
    private Node root;

    public Node find(int key) {
        Node p = root;
        while (p != null) {
            if (key < p.data) {
                p = p.left;
            } else if (key > p.data) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        Node p = root;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else { // data < p.data
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    public void delete(int data) {
        Node p = root; // p 指向要删除的节点
        Node pp = null; // pp 记录 p 的父节点
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) p = p.right;
            else p = p.left;
        }
        if (p == null) return; // 没找到
        // 要删除的节点有两个子节点
        if (p.left != null && p.right != null) { //寻找右️子树最小节点
            Node minP = p.right;
            Node minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data;
            p = minP; // 删除minP
            pp = minPP;
        }
        // 删除节点是叶子节点或仅有一个子节点
        Node child; // p 的子节点
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;
        else child = null;

        if (pp == null) root = child;
        else if (pp.left == p) pp.left = child;
        else pp.right =child;
    }



    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
