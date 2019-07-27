package com.lion.tree;

/**
 * 二叉查找树
 */
public class BinarySearchTree {
    private Node root;

    /**
     * 查找
     * 如果key == data return
     * 如果key > data 查右子树
     * 如果key < data 查左子树
     * @param key
     * @return
     */
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

    /**
     * 删除二叉搜索树
     *
     * @param data
     */
    public void delete(int data) {
        Node p = root; // p 指向要删除的节点
        Node pp = null; // pp 记录 p 的父节点
        // 寻找要删除的节点 p 为要删除的节点  pp为p的父节点
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) p = p.right;
            else p = p.left;
        }
        if (p == null) return; // 没找到
        // 要删除的节点有两个子节点,为了防止这个树断掉,需要将p节点右子树上最小的节点找到和p交换
        // 然后再删除最小的那个节点
        if (p.left != null && p.right != null) { //寻找右️子树最小节点
            Node minP = p.right;
            Node minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data;
            p = minP; // 待删除的最小节点
            pp = minPP;//待删除p的父节点
        }
        // 删除节点是叶子节点或仅有一个子节点
        Node child; // p 的子节点
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;
        else child = null; // 左右都为null

        if (pp == null) root = child; //意思是删除root节点
        else if (pp.left == p) pp.left = child;//删除pp的左孩子 p
        else pp.right =child;//删除pp的右孩子 p
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
