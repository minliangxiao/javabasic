package club.huangliang.interview.thread;
/*
* 线程不共享数据的demo
* */
public class Demo05 {

    public static void main(String[] args) {
        Thread t1 = new Demo05Thread();
        Thread t2 = new Demo05Thread();
        Thread t3 = new Demo05Thread();
        t1.start();
        t2.start();
        t3.start();
    }
}

class Demo05Thread extends Thread {
    private int count = 5;

    @Override
    public void run() {
        while (count > 0) {
            count--;
            System.out.println(Thread.currentThread().getName() + ": count=" + count);//Thread.currentThread().getName() 是获取当前线程的名称
        }
    }
}