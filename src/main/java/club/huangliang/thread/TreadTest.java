package club.huangliang.thread;

import java.util.ArrayList;
import java.util.Random;

public class TreadTest {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        final Random random = new Random();
        final ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            Thread thread = new Thread(()->{
                list.add(random.nextInt());
            });
            thread.start();
            thread.join();
        }
        System.out.println("时间"+(System.currentTimeMillis() - start));
        System.out.println("大小"+list.size());
    }
}
