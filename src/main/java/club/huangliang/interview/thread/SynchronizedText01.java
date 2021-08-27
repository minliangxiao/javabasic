package club.huangliang.interview.thread;

import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;

import java.util.logging.Logger;
//import lombok.extern.slf4j.Slf4j;


/**
 * 这是练习Synchronized
 */
//@Slf4j(topic = "c.SynchronizedText01")
public class SynchronizedText01 {
    static int counter=0;
    static Object lock=new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                synchronized (lock){
                    counter++;
                }
            }
        },"t1");

        Thread t2=new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                synchronized (lock){
                    counter--;
                }
            }
        },"t2");
        // 不用lambda表达式实现
        /*Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {

            }
        },"t3");*/
        t1.start();
        t2.start();
        t1.join();
        t2.join();
//        log.debug("{}",counter);
        System.out.print(counter);

    }
}
