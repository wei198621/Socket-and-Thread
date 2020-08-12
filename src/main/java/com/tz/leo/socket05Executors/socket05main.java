package com.tz.leo.socket05Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Author: tz_wl
 * Date: 2020/8/10 1:02
 * Content:
 */
public class socket05main {
    ///用 Executors.newCachedThreadPool() 等 替换自己新建的 new ThreadPoolExecutor
    ///
    public static void main(String[] args) {

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        // 以上三个底层都是 ThreadPoolExecutor
        //执行有连个  ***.execute(*);   ***.submit(*);
        singleThreadExecutor.execute(new MyRunnable05());
       /* singleThreadExecutor.execute(new MyRunnable05());
        singleThreadExecutor.execute(new MyRunnable05());
        singleThreadExecutor.execute(new MyRunnable05());*/

        Future<?> submit = singleThreadExecutor.submit(new MyRunnable05());

      /*  try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        boolean isDone = submit.isDone();  //sleep 是否执行决定了其是  true false
        System.out.println(isDone);


    }
}


class MyRunnable05 implements Runnable {

    public void run() {
        System.out.println("run==================" +Thread.currentThread().getName());
    }
}