import java.util.*;
//翻转字符串
//ABCD 
//ABCD BCDA CDAB DABC
//ABCDABCD 从0 到 4查看是否有就好 
public class ReverseEqual {
    public boolean checkReverseEqual(String s1, String s2) {
        // write code here
    	String s = s1 + s1;
      	char[] A = s.toCharArray();
        char[] B = s2.toCharArray();
        boolean flag = false;
        for(int i = 0; i < s2.length(); i++){
            for(int j = 0; j < s2.length(); j++){
                if(A[i+j] != B[j] ){
                    break;
                }else if(j == s2.length()-1 && A[i+j] == B[j]){
                   flag = true;
                }
            }
            
        }
        return flag;
    
    }
}