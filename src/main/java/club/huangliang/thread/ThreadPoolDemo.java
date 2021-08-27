package club.huangliang.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
        for (int i = 0; i <=100; i++) {
            executorService1.execute(new MyTask(i));

        }
    }

}
class MyTask implements Runnable{
    int i =0;
    public MyTask(int i){
        this.i = i;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"--"+i);
        try {
            // 业务逻辑
            Thread.sleep(1000L);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
