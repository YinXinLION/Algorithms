import java.util.*;
//基本字符串压缩
public class Zipper {
    public String zipString(String iniString) {
        // write code here
        char[] A = iniString.toCharArray();
        StringBuilder sb = new StringBuilder();
        int left = 0;
        while(left < A.length){
            String cur = String.valueOf(A[left]);
            int right = getNextChar(A,left);
            int len = right - left;
            sb.append(cur+len);
            left=right;
        }
        if(iniString.length()*2 == sb.length()){
            return iniString;
        }else{
            return sb.toString();
        }
     
    }
    public static int getNextChar(char[] arr, int i){
        char cur = arr[i];
        while(i < arr.length && arr[i] == cur){
            i++;
        }
        return i;
    }
}