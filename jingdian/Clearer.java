import java.util.*;
//清除行列
public class Clearer {
    public int[][] clearZero(int[][] mat, int n) {
        // write code here
    	boolean[] rowArray = new boolean[n];
        boolean[] columnArray = new boolean[n];
        //记录0的位置
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    rowArray[i] = true;
                    columnArray[j] = true;
                }
            }
        }
        //遍历
        for(int i = 0; i < n; i++){
            for(int j = 0;j < n;j++){
                if(rowArray[i] || columnArray[j]){
                    mat[i][j] = 0;
                }
            }
        }
		return mat;    
    }
}