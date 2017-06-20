package Alogrithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * Created by 殷鑫 on 2017/1/13.
 */
public class BinTreeTraverse {
    private int[] array = {1,2,3,4,5,6,7,8,9};
    private static List<Node> nodeList = null;
    private static StringBuilder str = new StringBuilder();
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

    public void createBinTree(){
        nodeList = new LinkedList<Node>();
        //将一个数组的值依次转换为Node节点
        for (int nodeIndex = 0;nodeIndex < array.length;nodeIndex++){
            nodeList.add(new Node(array[nodeIndex]));
        }
        //对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0;parentIndex < array.length /2 - 1; parentIndex++){
            //左孩子
            nodeList.get(parentIndex).leftChild = nodeList.get(parentIndex*2+1);
            //右孩子
            nodeList.get(parentIndex).rightChild = nodeList.get(parentIndex*2+2);
        }
        //最后一个父节点:因为自后一个父节点可能没有右孩子所以单独拿出来处理
        int lastParentIndex = array.length /2 - 1;
        // 左孩子
        nodeList.get(lastParentIndex).leftChild = nodeList
                .get(lastParentIndex * 2 + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).rightChild = nodeList
                    .get(lastParentIndex * 2 + 2);
        }
    }

    //线序遍历
    public static void preOrderTraverse(Node node)
    {
        if(node == null)
            return;
        System.out.println(node.data + " " );
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }


    //按层打印
    public static void print(Node node)
    {
        Node last,nlast = null;
        Queue<Node> nodes = new LinkedList<Node>();
        nodes.add(node);
        System.out.println(nodes);
        last = node;
        while (!nodes.isEmpty())
        {
            node = nodes.poll();
            int str = node.data;
            System.out.print(str+"   ");
            if (node.leftChild != null)//打印
            {
                nodes.offer(node.leftChild);
                nlast = node.leftChild;
            }

            if (node.rightChild != null)
            {
                nodes.offer(node.rightChild);
                nlast = node.rightChild;
            }

            if (str == last.data )
            {
                System.out.println("\n");
                last = nlast;
            }
        }
    }

    //二叉树的序列化
    public static  void xuliehua(Node node){
//        if(node!=null)
//       {
//        str.append(node.data+"!asdasd~~~");
//       }
//        if (node == null){
//            str.append("#!");
//        }

        if(node == null)
        {

            str.append("#!");
            return;
        }
        str.append(node.data + "!");
        System.out.println(node.data + " " );
        xuliehua(node.leftChild);
        xuliehua(node.rightChild);
    }
    public static void main(String[] args) {
        BinTreeTraverse binTreeTraverse = new BinTreeTraverse();
        binTreeTraverse.createBinTree();
//        System.out.println("线序");
//        print(nodeList.get(0));
        xuliehua(nodeList.get(0));
        System.out.println(str);
    }

}
