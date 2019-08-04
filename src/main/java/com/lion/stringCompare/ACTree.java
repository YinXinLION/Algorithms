package com.lion.stringCompare;

public class ACTree {
    public char data;
    public boolean isEndingChar = false;
    public ACTree[] children = new ACTree[26];
    public int length = -1; // 当isEndingChar=true时,记录模式串长度
    public ACTree fail; // 失败指针
    public ACTree(char data) {
        this.data = data;
    }

}
