package club.huangliang.interview.thread;
/*
*创建线程的方法1.
* 通过 继承Thread方法实现创建线程
* */
public class Demo01 {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Demo01thread();
        t.start();

        System.out.println("main方法");
    }
}
class Demo01thread extends Thread{
    @Override
    public void run() {
        System.out.println("线程启动");
    }
}
