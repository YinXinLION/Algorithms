import java.util.*;
//删除指定节点
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Remove {
    public boolean removeNode(ListNode pNode) {
        // write code here
        if(pNode.next == null){
            return false;
        }
        pNode.val = pNode.next.val;//将下一个节点的值赋值过来
        pNode.next = pNode.next.next;//删除下一个
        return true;
       	
    }
}