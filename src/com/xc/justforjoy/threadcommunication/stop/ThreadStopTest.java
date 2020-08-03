package com.xc.justforjoy.threadcommunication.stop;

/**
 * @author lxcecho
 * @since 2020/8/3
 * <p>
 * 一般在使用多线程时，大多数都会使用for while
 */
public class ThreadStopTest {

    public static void main(String[] args) {
        StopThread stopThread = new StopThread();
        Thread thread1 = new Thread(stopThread);
        Thread thread2 = new Thread(stopThread);
        thread1.start();
        thread2.start();
        int i = 0;
        while (true) {
            System.out.println("thread main... ");
            if (i == 300) {
                thread1.interrupt();
                thread2.interrupt();
                break;
            }
            i++;
        }
    }

}

class StopThread implements Runnable {
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            try {
                wait();
            } catch (Exception e) {
                stopThread();
            }
            System.out.println("thread is running...");
        }
    }

    public void stopThread() {
        flag = false;
    }
}