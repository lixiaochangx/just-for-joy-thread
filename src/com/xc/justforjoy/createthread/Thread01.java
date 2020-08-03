package com.xc.justforjoy.createthread;

/**
 * @author lxcecho
 * @since 2020/8/3
 * <p>
 * 创建线程的方式一：继承Thread类
 */
public class Thread01 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("i = " + i);
        }
    }
}
