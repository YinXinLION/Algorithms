import java.util.*;
//像素翻转
public class Transform {
    public int[][] transformImage(int[][] mat, int n) {
        // write code here
        if(mat == null){
            return null;
        }
        int temp = 0;
        //先将矩阵以次对角线互换 （如果是逆时针则为主对角线）
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n-i-1; j++){
          		temp = mat[i][j];
                mat[i][j] = mat[n-j-1][n-i-1];
                mat[n-j-1][n-i-1] = temp;
            }
        }
        //交换第i行到第n-i-1行
		for(int i=0;i<(n/2);++i){
            for(int j=0;j<n;j++){
                temp = mat[i][j];
                mat[i][j] = mat[n-i-1][j];
                mat[n-i-1][j] = temp;
            }
        }
        return mat;
    }
}