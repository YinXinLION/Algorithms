import java.util.*;
//确定两串乱序同构
public class Same {
    public boolean checkSam(String stringA, String stringB) {
        // write code here
        int lenA = stringA.length();
        int lenB = stringB.length();
        if(lenA != lenB){
            return false;
        }
        int[] A = new int[256];
        int[] B = new int[256];
        for(int i=0; i < lenA; i++ ){
            A[stringA.charAt(i)]++;
            B[stringB.charAt(i)]++;
        }
        for(int i = 0; i < 256; i++){
            if(A[i] != B[i]){
                return false;
            }
        }
        return true;
       
    }
}