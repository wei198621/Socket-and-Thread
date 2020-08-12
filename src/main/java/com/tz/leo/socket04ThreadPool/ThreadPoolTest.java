package com.tz.leo.socket04ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Author: tz_wl
 * Date: 2020/8/9 17:10
 * Content:
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(2);
        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        //创建线程池对象
        //        //参数1： 线程池中   核心对象数量
        //        //参数2： 线程池中   最大线程数
        //        //参数3： 空闲时间
        //        //参数4： 空闲时间 单位
        //        //参数5： 线程等待队列
        //        //参数6： 创建线程工厂
        //        //参数7： 线程拒绝处理器
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3,       //银行中的  开放窗口数 3 个
                5,   //银行中的  临时窗口数  5-3=2 个
                10,
                TimeUnit.SECONDS,
                workQueue,           //银行中的小板凳数 2 个
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy()
                );

        //修改i最数据看效果
        for (int i = 0; i < 5; i++) {
            threadPoolExecutor.execute(new MyRunnable());
        }

    }

}

class MyRunnable implements Runnable{
    public void run() {
        System.out.println("任务.... 线程名称：" + Thread.currentThread().getName());
    }
}