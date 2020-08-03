package com.xc.justforjoy.createthread;

/**
 * @author lxcecho
 * @since 2020/8/3
 */
public class ThreadTest {

    public static void main(String[] args) {

        System.out.println("多线程创建开始");

        // 创建一个线程

        // 第一种方式
        /*Thread01 thread01 = new Thread01();*/

        // 第二种方式
        Thread02 thread02 = new Thread02();
        Thread thread = new Thread(thread02);

        System.out.println("多线程创建启动：================");
        // 第一种方式启动线程
        /*thread01.start();*/

        // 第二种方式启动线程
        thread.start();

        // 第三种方式启动线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("第三种方式-i = " + i);
                }
            }
        }).start();

        System.out.println("多线程创建结束==============");
        System.out.println("main:=======");
        for (int i = 0; i < 100; i++) {
            System.out.println("main-i = " + i);
        }

        /**
         * 结果分析：
         * 调用start()方法后，代码并没有从上往下执行，而是有一条新的执行分支。
         * 注意：以画图形式演示多线程不同执行路径。
         */

    }

}
