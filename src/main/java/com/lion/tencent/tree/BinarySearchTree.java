package com.lion.tencent.tree;

public class BinarySearchTree {
    public Node root;
    public Node find(int value) {
        Node p = root;
        while (p != null) {
            if (p.value == value) {
                return p;
            } else if (p.value > value) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return null;
    }

    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
        }
        Node p = root;
        while (p != null) {
            if (p.value > data) {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            } else { // data > p.value
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            }
        }
    }

    public void delete(int data) {
        Node p = root;
        Node pp = null; // p 的父节点
        while (p != null && p.value != data) {
            pp = p;
            if (data > p.value) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if ( p == null) {
            return;
        }
        if (p.left != null && p.right != null) {
            Node minP = p.right;
            Node minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.value = minP.value;
            p = minP;
            pp = minPP;
        }
        Node child = null;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }
        if (pp == null) {
            root = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }
}
