package com.tz.leo.socket03.threadTest;

/**
 * Author: tz_wl
 * Date: 2020/8/9 14:37
 * Content:
 */
public class MyRunnable implements Runnable {
    public void run() {
        System.out.println("MyRunnable is running , 线程名称："+ Thread.currentThread().getName());
    }
}
