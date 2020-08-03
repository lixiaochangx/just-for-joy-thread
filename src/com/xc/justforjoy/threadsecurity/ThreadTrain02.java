package com.xc.justforjoy.threadsecurity;

/**
 * @author lxcecho
 * @since 2020/8/3
 * <p>
 * 需求：
 * 现在有100张火车票，有两个窗口同时抢火车票，请使用多线程模拟抢票效果。
 */
public class ThreadTrain02 implements Runnable {

    private int count = 100;

    public boolean flag = true;

    private Object obj = new Object();

    @Override
    public void run() {
        if (flag) {
            while (true) {
                synchronized (obj) {
                    /**
                     *  锁（同步代码块）在什么时候释放？——代码执行完，自动释放锁。
                     *  flag==true：先拿到 obj锁，再拿到 this锁 才能执行。
                     *  flag==false：先拿到this锁，再拿到obj锁 才能执行。
                     */
                    sale();
                }
            }
        } else {
            while (true) {
                sale();
            }
        }

    }

    public synchronized void sale() {
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

}
