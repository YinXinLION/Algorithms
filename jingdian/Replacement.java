import java.util.*;
//import java.util.*;

public class Replacement {
    public String replaceSpace(String iniString, int length) {
        // write code here
        char[] A = iniString.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++){
            if(A[i] == ' '){
                sb.append("%20");
            }else{
                sb.append(A[i]);
            }
        }
        return sb.toString();
    }
}
public class Replacement {
    public String replaceSpace(String iniString, int length) {
        // write code here
       	char[] A = iniString.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++){
            if(A[i] == ' '){
                sb.append("%20");
            }else{
                sb.append(A[i]);
            }
        }
        return sb.toString();
    }
}