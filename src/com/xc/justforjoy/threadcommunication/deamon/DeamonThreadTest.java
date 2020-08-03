package com.xc.justforjoy.threadcommunication.deamon;

/**
 * @author lxcecho
 * @since 2020/8/3
 * <p>
 * 什么是守护线程：
 * 进程线程（主线程挂了）守护线程也会被自动销毁。
 * 线程分为两种：一种是守护线程（后台线程），一种是用户线程（前台线程）。
 * 主线程或JVM进程挂了，守护线程也会被停止掉。GC其实也是守护线程。
 */
public class DeamonThreadTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new Deamon());
        //标识为 守护线程
        thread.setDaemon(true);
        thread.start();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("我是主线程。。。");
        }
        System.out.println("主线程执行完毕！");
    }
}

class Deamon implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("我是子线程。。。");
        }
    }
}
