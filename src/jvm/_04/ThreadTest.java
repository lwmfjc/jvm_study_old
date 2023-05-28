package jvm._04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreadTest {
    /**
     * 线程=>死循环
     */
    public static void createBusyThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                }
            }
        }, "testBusyThread");
        thread.start();
        System.out.println(thread.getName()+"启动并运行");
    }

    public static void createLockThread(
            final Object lock
    ) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        System.out.println(Thread
                                .currentThread()
                                .getName()+"释放线程主权进行等待");
                        lock.wait();
                        System.out.println(Thread
                                .currentThread()
                                .getName()+"重新激活");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "testLockThread");
        thread.start();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        createBusyThread();
        br.readLine();
        Object obj=new Object();
        createLockThread(obj);
    }
}
