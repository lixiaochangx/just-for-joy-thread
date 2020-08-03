package com.xc.justforjoy.threadsecurity;

/**
 * @author lxcecho
 * @since 2020/8/3
 */
public class ThreadTest {

    public static void main(String[] args) throws Exception{
        /*ThreadTrain threadTrain1 = new ThreadTrain();

        Thread t = new Thread(threadTrain1);
        Thread t2 = new Thread(threadTrain1);
        t.start();
        Thread.sleep(40);
        threadTrain2.flag = false;
        t2.start();*/

        ThreadTrain threadTrain2 = new ThreadTrain();

        Thread t = new Thread(threadTrain2);
        Thread t2 = new Thread(threadTrain2);
        t.start();
        Thread.sleep(40);
        threadTrain2.flag = false;
        t2.start();

    }

}
