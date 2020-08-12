package com.tz.leo.socket03.threadTest;

/**
 * Author: tz_wl
 * Date: 2020/8/9 14:45
 * Content:
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread is running , 线程名称："+ Thread.currentThread().getName());
    }
}
