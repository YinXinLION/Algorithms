import java.util.*;
//链表划分
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        // write code here
    
        ListNode small = null;
        ListNode big = null;
        ListNode t = null;
        ListNode w = null;
        while(pHead != null){
            ListNode next = pHead.next;
            pHead.next = null;
         	if(pHead.val < x){
                if(small == null){
                    small = t = pHead;
       
                }else{
                    t.next = pHead;
                    t = t.next;
                }
            }else{
                if(big == null){
                    big = w = pHead;
                }else{
                    w.next = pHead;
                    w = w.next;
                }
            }
           
        	pHead = next;
        }
      if(small == null){
          return big;
      }
        t.next = big;
        return small;
        
    }
}