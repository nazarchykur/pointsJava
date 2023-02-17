package com.company.multithreading;

public class _2_RunExp1 implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String args[]) {
        System.out.println("some work in main starts ..");
        _2_RunExp1 r1 = new _2_RunExp1();
        Thread thread1 = new Thread(r1);
        thread1.start();
        System.out.println("some work in main ends..");
        
        /*
            some work in main starts ..
            some work in main ends..
            Thread is running...
         */

    }
}  

/*
    2. public void run()
    
    This thread is used to do an action for a thread. The run() method is instantiated if the thread was constructed 
    using a separate Runnable object.

 */