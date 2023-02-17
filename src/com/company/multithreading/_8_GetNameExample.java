package com.company.multithreading;

/*
    8. public final String getName()
    
    This method of thread class is used to return the name of the thread. We cannot override this method in our program, 
    as this method is final.

 */

public class _8_GetNameExample extends Thread {
    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String args[]) {
        // creating two threads   
        _8_GetNameExample thread1 = new _8_GetNameExample();
        _8_GetNameExample thread2 = new _8_GetNameExample();
        System.out.println("Name of thread1: " + thread1.getName());
        System.out.println("Name of thread2: " + thread2.getName());
        thread1.start();
        thread2.start();
    }
    
    /*
        Name of thread1: Thread-0
        Name of thread2: Thread-1
        Thread is running...
        Thread is running...

     */
}  

