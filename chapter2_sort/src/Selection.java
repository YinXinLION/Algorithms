/**
 * Created by yinxin on 16-12-1.
 */
//选择排序
public class Selection {
    public static void main(String[] args) {
        //将数组按升序排列
        int a[] = {5,1,3,2,6};
        for (int i = 0; i < a.length; i++)
        {
            int min = i;
            for (int j = i + 1; j < a.length; j++)
            {
                if (a[i] > a[j])
                {
                    min = j;
                }
                if (min == j)
                {
                    int temp = a[i];
                    a[i] = a[min];
                    a[min] = temp;
                }

            }
        }

        for (int i = 0; i < a.length; i++)
        {
            System.out.println(a[i]);
        }
    }
}
