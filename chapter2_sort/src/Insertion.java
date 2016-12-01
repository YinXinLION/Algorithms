/**
 * Created by yinxin on 16-12-1.
 */

//插入排序
    /*
    * 需要将其余所有元素在插入之前都向右移动一位
    * */
public class Insertion {
    public static void main(String[] args) {
        int a[] = {0,5,1,3,2,6};
        for (int i = 1; i < a.length; i++)
        {
            for (int j = i; j > 0&& less(a[j],a[j-1]); j--)
            {
                int temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
            }
        }
        for (int i = 0; i < a.length; i++)
        {
            System.out.println(a[i]);
        }
    }

    private static boolean less(int a, int b)
    {
        return a < b;
    }
}
