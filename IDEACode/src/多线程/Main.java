package 多线程;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadFactory;

/**
 * Created by 殷鑫 on 2017/1/8.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //测试arraylist
        List<Object> list = new ArrayList<Object>();
        //线程数量1000
        int threadCount = 1000;CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        //启动子线程
        for (int i = 0; i < threadCount; i++)
        {
            Thread thread = new Thread(new Mythread(list,countDownLatch));
            thread.start();
        }
        countDownLatch.await();
        System.out.println(list.size());
    }
}
