package com.lion.stringCompare;

public class Tire {

    private TireNode root = new TireNode('/');
    //插入字符串到字典树
    public void insert(char[] text) {
        TireNode p = root;
        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                TireNode newNode = new TireNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    public boolean find(char[] text) {
        TireNode p = root;
        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        if (p.isEndingChar == true) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

    }



    /**
     * 这里默认字符串只有a-z26小写
     */
    public class TireNode {
        private char data;
        public TireNode[] children = new TireNode[26];
        public boolean isEndingChar = false;
        public TireNode(char data) {
            this.data = data;
        }
    }
}
