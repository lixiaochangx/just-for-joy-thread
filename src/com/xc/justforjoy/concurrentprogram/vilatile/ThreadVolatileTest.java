package com.xc.justforjoy.concurrentprogram.vilatile;

/**
 * @author lxcecho
 * @since 2020/8/3
 */
public class ThreadVolatileTest {

    public static void main(String[] args) throws Exception {
        ThreadVolatile threadVolatile = new ThreadVolatile();
        threadVolatile.start();
        Thread.sleep(3000);
        threadVolatile.setRunning(false);
        System.out.println("flag 已经设置为false");
        Thread.sleep(1000);
        System.out.println(threadVolatile.flag);
    }

}

class ThreadVolatile extends Thread {
    public volatile boolean flag = true;

    @Override
    public void run() {
        System.out.println("开始执行子线程。。。");
        while (flag) {

        }
        System.out.println("线程停止。。。");
    }

    public void setRunning(boolean flag) {
        this.flag = flag;
    }
}
