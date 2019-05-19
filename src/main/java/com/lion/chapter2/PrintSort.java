package com.lion.chapter2;

/**
 *  打印两个有序链表的公共部分
 */
public class PrintSort {
    public static void main(String[] args) {

    }

    public static void printCommonPart(Node head1, Node head2) {
        while (head1 != null && head2 !=null) {
            if (head1.value > head2.value) {
                head2 = head2.next;
            } else if (head1.value < head2.value) {
                head1 = head1.next;
            } else {
                System.out.println(head1.value);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println("--");
    }
}
