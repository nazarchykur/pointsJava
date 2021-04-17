package com.company.notify_wait.ex1;

public class WaitNotify {
    public static void main(String[] args) throws InterruptedException {
        Object forSync = new Object();

        new Thread(() ->{
            synchronized (forSync) {
                try {
                    System.out.println(Thread.currentThread().getName() + " : reade to wait");
                    forSync.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " : continue working after notify");
            }
        }).start();

        Thread.sleep(2000);

        new Thread(()->{
            synchronized (forSync) {
                System.out.println(Thread.currentThread().getName() + " : ready for notify");
                forSync.notify();
                System.out.println(Thread.currentThread().getName() + " : have finished");
            }
        }).start();
    }
}
