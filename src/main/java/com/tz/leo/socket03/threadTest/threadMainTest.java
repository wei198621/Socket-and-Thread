package com.tz.leo.socket03.threadTest;

/**
 * Author: tz_wl
 * Date: 2020/8/9 14:38
 * Content:
 */
public class threadMainTest {
    //创建线程的三种方式
    //方式一  实现runnable 接口
    //方式二  继承Thread类
    //方式三   threadPool

    public static void main(String[] args) {


        System.out.println("main is running , 线程名称："+ Thread.currentThread().getName());

        //************************************************************
        //方式一  实现runnable 接口
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();    //线程名称：Thread-0

        //************************************************************
        //方式二  继承Thread类

        MyThread myThread = new MyThread();
        myThread.start();


        //************************************************************
        //方式三   threadPool
    }




}

