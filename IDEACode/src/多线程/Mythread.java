package 多线程;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

/**
 * Created by 殷鑫 on 2017/1/8.
 */
public class Mythread implements Runnable{
    private List<Object> list;
    private CountDownLatch countDownLatch;

    public Mythread(List<Object> list,CountDownLatch countDownLatch){
        this.list=list;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 0;i < 100 ; i++){
            list.add(new Object());  //没个线程添加100个元素
        }
        countDownLatch.countDown();
    }
}
