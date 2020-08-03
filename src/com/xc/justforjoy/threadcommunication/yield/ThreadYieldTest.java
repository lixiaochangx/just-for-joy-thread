package com.xc.justforjoy.threadcommunication.yield;

/**
 * @author lxcecho
 * @since 2020/8/3
 */
public class ThreadYieldTest {
    public static void main(String[] args) {
        YieldThread t = new YieldThread();
        YieldThread t2 = new YieldThread();
        t.start();
        //暂停当前正在执行的线程，并执行其他线程。（可能没效果）
        t2.yield();
        t2.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("Main --" + i);
        }
    }
}

class YieldThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "-" + i);
        }
    }
}
