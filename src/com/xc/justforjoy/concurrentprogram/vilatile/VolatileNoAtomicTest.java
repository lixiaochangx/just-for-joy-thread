package com.xc.justforjoy.concurrentprogram.vilatile;

/**
 * @author lxcecho
 * @since 2020/8/3
 */
public class VolatileNoAtomicTest {

    public static void main(String[] args) {
        VolatileNoAtomic[] arr = new VolatileNoAtomic[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = new VolatileNoAtomic();
        }
        for (int i = 0; i < 10; i++) {
            arr[i].start();
        }
    }

}

class VolatileNoAtomic extends Thread {

    private static volatile int count;

    //private static AtomicInteger count = new AtomicInteger(0);

    private static void addCount() {
        for (int i = 0; i < 1000; i++) {
            count++;
            //count.incrementAndGet();
        }
        System.out.println(count);
    }

    @Override
    public void run() {
        addCount();
    }
}

