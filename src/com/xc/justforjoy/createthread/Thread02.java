package com.xc.justforjoy.createthread;

/**
 * @author lxcecho
 * @since 2020/8/3
 * <p>
 * 创建线程的方式二：实现Runnable接口
 */
public class Thread02 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("i = " + i);
        }
    }
}
