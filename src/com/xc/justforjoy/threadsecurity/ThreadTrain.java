package com.xc.justforjoy.threadsecurity;

/**
 * @author lxcecho
 * @since 2020/8/3
 * <p>
 * 需求：
 * 现在有100张火车票，有两个窗口同时抢火车票，请使用多线程模拟抢票效果。
 */
public class ThreadTrain implements Runnable {

    private static int count = 100;

    public boolean flag = true;

    @Override
    public void run() {
        /*if (flag) {
            while (count > 0) {
                sale();
            }
        }else{
            while (count > 0) {
                sale();
            }
        }*/

        while (count > 0) {
            sale2();
        }
    }

    private Object obj = new Object();

    public void sale() {
        synchronized (obj) {
            if (count > 0) {
                try {
                    Thread.sleep(40);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "==出售第" + (100 - count + 1) + "张票。");
                count--;
            }
        }
    }

    public static synchronized void sale2() {
        if (count > 0) {
            try {
                Thread.sleep(40);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "==出售第" + (100 - count + 1) + "张票。");
            count--;
        }
    }

    public void sale3() {
        synchronized (ThreadTrain.class) {
            if (count > 0) {
                try {
                    Thread.sleep(40);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "==出售第" + (100 - count + 1) + "张票。");
                count--;
            }
        }
    }
}

