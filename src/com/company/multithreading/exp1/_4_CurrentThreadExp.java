package com.company.multithreading.exp1;

/*
    4. public static Thread currentThread()
    
    It returns a reference to the currently running thread.

 */

public class _4_CurrentThreadExp extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String args[]) {
        System.out.println("some work in main starts ..");
        _4_CurrentThreadExp thread1 = new _4_CurrentThreadExp();
        _4_CurrentThreadExp thread2 = new _4_CurrentThreadExp();
        thread1.start();
        thread2.start();
        System.out.println("some work in main ends..");
        
        /*
            some work in main starts ..
            Thread-0
            some work in main ends..
            Thread-1
         */
    }
}  