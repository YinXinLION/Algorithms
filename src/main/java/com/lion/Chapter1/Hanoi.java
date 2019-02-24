package com.lion.Chapter1;

public class Hanoi {
    static int m = 0;
    public static void hanoiProblem(int num, String left, String mid, String right) {
        if (num == 1) {
            move(1, left, right);
        }else {
            hanoiProblem(num - 1, left , right, mid);
            move(num, left, right);
            hanoiProblem(num - 1, mid , left, right);
        }

    }

    public static void move(int disks,String N,String M)
    {
        System.out.println("第" + (++m) +" 次移动 : " +" 把 "+ disks+" 号圆盘从 " + N +" ->移到->  " + M);
    }

    public static void main(String[] args) {
        hanoiProblem(2,"A", "B", "C");
    }
}
