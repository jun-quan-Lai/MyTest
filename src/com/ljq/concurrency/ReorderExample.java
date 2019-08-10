package com.ljq.concurrency;


/**
 * 指令重排序
 */
public class ReorderExample {
    int a = 0;
    boolean flag = false;

    public void writer() {
        a = 1;
        flag = true;
    }

    public void reader() {
        if (flag) {//存在控制依赖
            int i = a * a;
            System.out.println("Thread B: " + i);
        }
    }

    public static void main(String[] args) {
        ReorderExample reorderExample = new ReorderExample();
        Thread A = new Thread(() ->
            reorderExample.writer()
        );

        Thread B = new Thread(() ->
            reorderExample.reader()//i不一定总是1
        );

        A.start();
        B.start();

    }

}
