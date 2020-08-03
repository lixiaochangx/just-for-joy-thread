package com.xc.justforjoy.threadcommunication.join;

/**
 * @author lxcecho
 * @since 2020/8/3
 * <p>
 * 创建一个线程，子线程执行完毕后，主线程才能执行。
 */
public class ThreadJoinTest {
    public static void main(String[] args) {
        ThreadJoin threadJoin = new ThreadJoin();
        Thread thread = new Thread(threadJoin);
        Thread thread2 = new Thread(threadJoin);
        //Priority值从1-10值 值越大 不代表每次都被执行，只是CPU调度会优先分配
        //thread.setPriority(10);
        thread.start();
        thread2.start();
        try {
            //其他线程变为等待状态，等t1线程执行完后才能执行join方法
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 100; i++) {
            System.out.println("Main Thread--主线程--" + i);
        }
    }
}

class ThreadJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().toString() + "子线程-" + i);
        }
    }
}
