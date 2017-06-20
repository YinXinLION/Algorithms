package 二叉树.二叉查找树;


/**
 * Created by 殷鑫 on 2017/5/21.
 */
public class BinarySearchTree<T extends Comparable<T>> {
    public Node root;
    //插入
    public boolean insert(T i){
        if (root == null){   //如果没有root，则添加
            root = new Node(i);
            return true;
        }
        Node current = root;
        while (true){
            //如果i比当前的节点小
            if (i.compareTo((T)current.data) < 0){
                if (current.left != null){
                    current = current.left;
                }else {
                    //如果是null则进行插入
                    current.left = new Node(i);
                    break;
                }
            }else {
                if (current.right != null){
                    current = current.right;
                }else {
                    current.right = new Node(i);;
                    break;
                }
            }
        }
        return true;
    }

    //contain方法
    public boolean contain(T t){
        Node current = root;
        while (true){
            if (current.data.equals(t)){
                return true;
            }
            if (t.compareTo((T)current.data) < 0){
                if (current.left == null){
                    return false;
                }
                current = current.left;
            }
            if (t.compareTo((T)current.data) > 0){
                if (current.right == null){
                    return false;
                }
                current = current.right;
            }

        }


    }
}
class Node {
    public Object data;
    public Node left;
    public Node right;

    public Node(Object d) {
        this.data = d;
    }
}