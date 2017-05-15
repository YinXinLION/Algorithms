import java.util.*;
//原串翻转
public class Reverse {
    public String reverseString(String iniString) {
        // write code here
        char[] array = iniString.toCharArray();
        for(int i = 0,j = array.length-1; i < j; i++, j--){
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return new String(array);
    }
}