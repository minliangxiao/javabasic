package club.huangliang.interview.thread;
/*
* 线程的共享数据
* */
public class Demo06 {
    public static void main(String[] args) {
        Thread t = new Demo06Thread();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        Thread t4 = new Thread(t);
        Thread t5 = new Thread(t);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

class Demo06Thread extends Thread {
    private int count = 5;

    @Override
    public void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + ", count=" + count);
    }
}