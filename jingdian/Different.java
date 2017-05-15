import java.util.*;
//确定字符串互异
public class Different {
    public boolean checkDifferent(String iniString) {
        // write code here
        char[] array = iniString.toCharArray();
        boolean flag = true;
        for(int i = 0; i < array.length -1; i++){
            for(int j = i+1; j < array.length; j++){
                if(array[i] == array[j]){
                    flag = false;
                    break;
                }
            }
            if(flag == false)
                break;
        }
        return flag;
    }
}