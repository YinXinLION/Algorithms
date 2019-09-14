package com.lion.think.huishuo;

/**
 * 八皇后问题  在8*8的棋盘上，放置8枚棋子 保证 每个棋子 行列对角线不会超过2个的情况
 *
 * 使用回溯思想
 */
public class EightQueen {
    private static int[] result = new int[8]; //下标表示行 值表示列

    public void cal8Queen(int row) {
        if (row == 8) {
            printQueens(result);
            return;
        }
        for(int column = 0; column < 8; column++) {
            if (isOk(row, column)) {
                result[row] = column;
                cal8Queen(row+1);
            }
        }
    }

    private boolean isOk(int row, int column) {
        int leftup = column - 1, rightup = column+1;
        for (int i = row - 1; i >= 0; i--) { //逐行往上考察每一行
            if (result[i] == column) return false;
            if (leftup >= 0) {
                if (result[i] == leftup) return false;
            }
            if (rightup < 8) {
                if (result[i] == rightup) return false;
            }
            -- leftup;
            -- rightup;
        }
        return true;
    }

    private void printQueens(int[] result) { // 打印成二维矩阵

    }
}
