package com.xc.justforjoy.threadsecurity;

/**
 * @author lxcecho
 * @since 2020/8/3
 * 设计4个线程，其中两个线程每次对j增加1，另外两个线程对j每次减少1。写出程序。
 */
public class ThreadExer {

    public static void main(String[] args) {
        ThreadExer exer = new ThreadExer();
        Inc inc = exer.new Inc();
        Dec dec = exer.new Dec();
        Thread t1 = new Thread(inc);
        Thread t2 = new Thread(inc);
        Thread t3 = new Thread(dec);
        Thread t4 = new Thread(dec);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    private int j = 0;

    public synchronized void inc() {
        j++;
        System.out.println(Thread.currentThread().getName() + "-inc:" + j);
    }

    public synchronized void dec() {
        j--;
        System.out.println(Thread.currentThread().getName() + "-dec:" + j);
    }

    class Inc implements Runnable {

        @Override
        public void run() {
            inc();
        }
    }

    class Dec implements Runnable {
        @Override
        public void run() {
            dec();
        }
    }
}
