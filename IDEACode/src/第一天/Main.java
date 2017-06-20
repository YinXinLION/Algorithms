package 第一天;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by 殷鑫 on 2017/1/11.
 */
public class Main {
    public static void print(int index,Object object){
        System.out.println(String.format("{%d},%s",index,object.toString()));
    }
    public static void demoMapTable(){
        Map<String,String> map = new HashMap<String,String>();
        for (int i = 0; i < 4; i++){
            map.put(String.valueOf(i),String.valueOf(i*i));
        }
        print(1,map);
        for (Map.Entry<String,String> entry: map.entrySet()){
            print(2,entry.getKey()+"|"+entry.getValue());
        }
    }
    public static void main(String[] args) {
//        print(1,"Hello");
        demoMapTable();
    }
}
