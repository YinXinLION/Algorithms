package 二叉树;

/**
 * Created by 殷鑫 on 2017/5/21.
 */
public class Main {
    public static void main(String[] args) {
        Node a = new Node(Integer.valueOf(1));
        Node b = new Node(Integer.valueOf(2));
        Node c = new Node(Integer.valueOf(3));
        a.left = b;
        a.right = c;
    }
}
class Node {
    public Object data;
    public Node left;
    public Node right;
    public Node(Object d){
        this.data = d;
    }
}
