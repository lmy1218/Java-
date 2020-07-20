package com.lmy.thread;
/**
 * @Project java基础
 * @Package com.lmy.thread
 * @author Administrator
 * @date 2020/5/30 15:40
 * @version V1.0
 */

import java.util.concurrent.*;

/**
 * @author Administrator
 * @ClassName ThreadPoolTest
 * @Description 线程池创建
 * @date 2020/5/30 15:40
 **/

public class ThreadPoolTest {

    public static void main(String[] args) {
//        defaultThreadPoolCreate();
        // 手动创建线程池
        ExecutorService executor = new ThreadPoolExecutor(
                2,
                5,
                1,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy()
//                new ThreadPoolExecutor.CallerRunsPolicy()
                new ThreadPoolExecutor.DiscardPolicy()
                );

        try {
            for (int i = 0; i <= 9; i++) {
                executor.execute(() -> System.out.println(Thread.currentThread().getName() + "\t 办理业务") );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }


    // JDK提供的创建线程池的方法
    private static void defaultThreadPoolCreate() {
        // 一池固定多个线程
        ExecutorService executor = Executors.newFixedThreadPool(5);
        // 一池一个线程
        ExecutorService executor1 = Executors.newSingleThreadExecutor();
        // 一池多个线程
        ExecutorService executor2 = Executors.newCachedThreadPool();

        try {
            for (int i = 0; i <= 10; i++) {
                executor2.execute(() -> System.out.println(Thread.currentThread().getName() + "\t 办理业务") );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

}
