package com.ljq.concurrency;

public class VolatileFeaturesExample {
    volatile long v1 = 0L;

    public void set(long l) {
        v1 = l;
    }

    public void getAndIncrement() {
        v1 ++;
    }

    public long get() {
        return v1;
    }

    public static void main(String[] args) {
        VolatileFeaturesExample volatileFeaturesExample = new VolatileFeaturesExample();
        Thread thread = new Thread(() -> {
            int i =1;
            while (i < 1000) {
                volatileFeaturesExample.set(i);
                i++;
            }
        });

        Thread t2 = new Thread(() -> {
            int j = 1;
            while (j < 1000) {
                volatileFeaturesExample.getAndIncrement();
                j++;
            }
        });

        Thread t1 = new Thread(() -> {
            int j = 1;
            while (j < 10) {
                System.out.println(volatileFeaturesExample.get());
                j ++;
            }
        });
        thread.start();
        t1.start();
        t2.start();
    }
}
