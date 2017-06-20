package Alogrithm;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 殷鑫 on 2017/1/13.
 */
//按层打印
public class BinTreeFirst {
    private int[] array = {1,2,3,4,5,6,7,8,9};
    private static List<Node> nodeList = null;

    //节点
    private static class Node{
        Node leftChild;
        Node rightChild;
        int data;

        Node(int newData){
            leftChild = null;
            rightChild = null;
            data = newData;
        }
    }


    public static void main(String[] args) {

    }
}
