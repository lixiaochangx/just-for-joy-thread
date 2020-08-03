package com.xc.justforjoy.threadcommunication;

/**
 * @author lxcecho
 * @since 2020/8/3
 */
public class ThreadExer {
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
            synchronized (res) {
                if (res.flag) {
                    /**
                     * 当前线程等待。wait():类似于sleep，可以让当前线程从运行状态变为休眠状态。
                     * wait 使用在多线程之间同步和synchronized一起使用。
                     * wait可以释放锁，sleep不能释放锁。
                     */
                    try {
                        res.wait();
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
                //和wait一起使用，唤醒另一个线程，唤醒从阻塞状态变为运行状态
                res.notify();
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
            synchronized (res) {
                if (!res.flag) {
                    try {
                        res.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(res.userSex + "---" + res.userName);
                res.flag = false;
                res.notify();
            }
        }
    }
}


class Res {
    public String userSex;
    public String userName;
    //线程通讯表示
    public boolean flag = false;
}