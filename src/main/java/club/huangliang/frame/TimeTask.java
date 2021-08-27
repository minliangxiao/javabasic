package club.huangliang.frame;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 关于定时任务方面的学习
 */
public class TimeTask {
    /*注意定时任务测试的时候最好用main函数，不要用junit因为junit在主线程结束后会kill子线程*/

    public static void main(String[] args) {

        // 创建Timer对象（Timer对象是jdk原装的定时任务对象，虽然现在企业中很少用，但是还是不错的）
        /*
        * Timer对象是原子性的线程安全的  在多任务执行时会出现线程等待现象
        * */
        Timer timer=new Timer();//一个Timer对象在执行多个定时任务时使用的是同一个线程（意思就是一个Timer）
        //执行定时任务
        /*
        * timer.schedule参数
        * 参数1：TimerTask对象 定时任务对象，负责具体的逻辑实现
        * 参数2：任务什么时候启动
        * 参数3：执行任务的时间间隔
        * */
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"定时任务执行了");
            }
        },new Date(),1000);

        System.out.println(Thread.currentThread().getName()+"主线程");
    }
}
