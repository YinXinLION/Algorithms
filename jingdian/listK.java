/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
//寻找倒数第K个节点
//或者 使用Stack，将结点压入栈中，再取出第k个就好
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
		if(head == null)
            return head;
        ListNode node = head;
        int count = 0;
        while(node != null){
            count++;
            node = node.next;
        }
        if(count < k) return null;
        ListNode p = head;
        for(int i = 0; i < count - k; i++){
            p = p.next;
            
        }
        return p;
            
    }
}