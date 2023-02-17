package com.company.multithreading.exp1;

/*
13. public final void suspend()

This method is used to suspend the currently running thread temporarily. Using the resume() method, you can resume the suspended thread.

 */
public class _13_SuspendExp extends Thread {
    public void run() {
        for (int i = 1; i < 5; i++) {
            try {
                sleep(500);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        _13_SuspendExp thread1 = new _13_SuspendExp();
        _13_SuspendExp thread2 = new _13_SuspendExp();
        _13_SuspendExp thread3 = new _13_SuspendExp();
        thread1.start();
        thread2.start();
        thread2.suspend(); // deprecated
        thread3.start();
    }
    
    /*
        Thread-0
        1
        Thread-2
        1
        Thread-0
        2
        Thread-2
        2
        Thread-0
        3
        Thread-2
        3
        Thread-0
        4
        Thread-2
        4

     */
}