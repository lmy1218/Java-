package com.lmy.thread;
/**
 * @Project java基础
 * @Package com.lmy.thread
 * @author Administrator
 * @date 2020/5/29 9:36
 * @version V1.0
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Administrator
 * @ClassName ThreadByCallableDemo
 * @Description 线程创建
 * @date 2020/5/29 9:36
 **/

class MyThread implements Runnable {

    @Override
    public void run() {

    }
}


class MyThread2 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 1024;
    }
}

public class ThreadByCallableDemo {

    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());
        new Thread(futureTask, "AA").start();
        int index = 1;
        Integer index2 = null;
        try {
            index2 = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(index + index2);

        System.out.println(Runtime.getRuntime().availableProcessors());
    }

}
