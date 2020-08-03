package com.xc.justforjoy.concurrentprogram;

/**
 * @author lxcecho
 * @since 2020/8/3
 * <p>
 * 并发编程测试
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        Res res = new Res();
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo(res);
        ThreadLocalDemo threadLocalDemo2 = new ThreadLocalDemo(res);
        ThreadLocalDemo threadLocalDemo3 = new ThreadLocalDemo(res);
        threadLocalDemo.start();
        threadLocalDemo2.start();
        threadLocalDemo3.start();
    }

}

class Res {
    /**
     * 生成序列号共享变量
     */
    private static Integer count = 0;
    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public Integer getNum() {
        int count = threadLocal.get() + 1;
        threadLocal.set(count);
        return count;
    }
}

class ThreadLocalDemo extends Thread {
    private Res res;

    public ThreadLocalDemo(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + "--i---" + i + "-num:" + res.getNum());
        }
    }
}
