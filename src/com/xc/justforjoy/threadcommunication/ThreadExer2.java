package com.xc.justforjoy.threadcommunication;

/**
 * @author lxcecho
 * @since 2020/8/3
 * <p>
 * 有T1、T2、T3三个线程，如何怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
 */
public class ThreadExer2 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread.start();
        try {
            myThread.join();
        } catch (Exception e) {

        }
        myThread1.start();
        try {
            myThread1.join();
        } catch (Exception e) {

        }
        myThread2.start();
        try {
            myThread2.join();
        } catch (Exception e) {

        }
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "-" + i);
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread().getName() + "-" + i);
        }
    }
}