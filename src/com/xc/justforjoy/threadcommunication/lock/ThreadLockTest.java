package com.xc.justforjoy.threadcommunication.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lxcecho
 * @since 2020/8/3
 */
public class ThreadLockTest {

    public static void main(String[] args) {
        Res res = new Res();
        InThread in = new InThread(res);
        OutThread out = new OutThread(res);
        in.start();
        out.start();
    }

}

/**
 * 输入线程
 */
class InThread extends Thread {
    private Res res;

    public InThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            try {
                res.lock.lock();//相当于synchronized
                if (res.flag) {
                    try {
                        res.condition.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (count == 0) {
                    res.userName = "李小昌";
                    res.userSex = "女";
                } else {
                    res.userSex = "男";
                    res.userName = "杰瑞";
                }
                //求奇数偶数算法
                count = (count + 1) % 2;
                res.flag = true;
                res.condition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                res.lock.unlock();
            }
        }
    }

}

/**
 * 输出线程
 */
class OutThread extends Thread {
    private Res res;

    public OutThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (!res.flag) {
                    try {
                        res.condition.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(res.userSex + "---" + res.userName);
                res.flag = false;
                res.condition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                res.lock.unlock();
            }
        }
    }
}


class Res {
    public String userSex;
    public String userName;
    //线程通讯表示
    public boolean flag = false;

    //可重入锁
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
}