package jvm._04;

import java.util.concurrent.TimeUnit;

public class TestStack {

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();


        new Thread(() -> {
            synchronized (o1) {
                try {
                    TimeUnit.SECONDS.sleep(2);

                    synchronized (o2) {

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(() -> {
            synchronized (o2) {
                try {
                    TimeUnit.SECONDS.sleep(1);

                    synchronized (o1) {

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
