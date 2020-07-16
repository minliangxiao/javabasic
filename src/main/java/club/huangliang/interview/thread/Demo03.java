package club.huangliang.interview.thread;

/*
 * 说明线程运行时的随机性的demo
 * */
public class Demo03 {
    public static void main(String[] args) {
        Thread t=new Demo03Thread();
        t.start();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("main：运行main方法");
                Thread.sleep(100);//当前线程睡眠
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Demo03Thread extends Thread {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread： 运行线程的方法");
                Thread.sleep(100);//让当前线程睡眠100毫秒
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
