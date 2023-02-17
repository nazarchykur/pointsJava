package com.company.multithreading.exp1;

/*
    24. public static boolean holdsLock(Object obj)
    
    This thread method checks if the currently executing thread holds the monitor lock on the specified object. 
    If it does, then this threading method will return true.

 */

public class _24_HoldLockExp implements Runnable {
    public void run() {
        System.out.println("Currently executing thread is: " + Thread.currentThread().getName());
        System.out.println("Does thread holds lock? " + Thread.holdsLock(this));
        
        synchronized (this) {
            System.out.println("Does thread holds lock? " + Thread.holdsLock(this));
        }
    }

    public static void main(String[] args) {
        _24_HoldLockExp g1 = new _24_HoldLockExp();
        Thread thread1 = new Thread(g1);
        thread1.start();
    }
    
    /*
        Currently executing thread is: Thread-0
        Does thread holds lock? false
        Does thread holds lock? true
     */
}  
