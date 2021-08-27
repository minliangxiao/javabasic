package club.huangliang.Quartz.demo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

/**
 * 由于没有配置文件所以这个项目并不能跑起来，但是Quartz的实现大致就是这个样子。
 */
public class MyScheuler {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        // 1.创建调度器Scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        //2.创建JobDetail实例，并与PrintWords类绑定（Job就是执行的内容）
        JobDetail jobDetail = JobBuilder.newJob(PrintWordsJob.class).withIdentity("自定义的打印Job","group1").build();
        //3.创建Trigger实例，每隔1s执行一次
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger","triggerGoup1")
                .startNow()//立即执行
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(1) //每隔一秒执行
                        .repeatForever()).build();//一直执行

        //4.执行
        scheduler.scheduleJob(jobDetail,trigger);
        System.out.println("===开始执行调度任务=====");

        //睡眠
        TimeUnit.MINUTES.sleep(1);
        scheduler.shutdown();
        System.out.println("======关闭调度任务======");

    }
}
