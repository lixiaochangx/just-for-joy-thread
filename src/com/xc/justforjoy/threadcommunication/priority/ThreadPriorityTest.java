package com.xc.justforjoy.threadcommunication.priority;

/**
 * @author lxcecho
 * @since 2020/8/3
 */
public class ThreadPriorityTest {

    public static void main(String[] args) {
        ThreadPriority threadPriority = new ThreadPriority();
        Thread t1 = new Thread(threadPriority);
        Thread t2 = new Thread(threadPriority);
        t1.start();
        //注意设置了优先级，不代表每次都一定会被执行。只是CPU调度会有限分配
        t1.setPriority(10);
        t2.start();
    }

}

class ThreadPriority implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().toString() + "--i:" + i);
            Thread.yield();
        }
    }
}