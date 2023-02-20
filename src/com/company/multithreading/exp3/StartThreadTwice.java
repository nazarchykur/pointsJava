package com.company.multithreading.exp3;


/*
    Can we start a thread twice
    
    No. After starting a thread, it can never be started again. If you does so, an IllegalThreadStateException is thrown. 
    In such case, thread will run once but for second time, it will throw exception.

 */
public class StartThreadTwice extends Thread {
    public void run() {
        System.out.println("running...");
    }

    public static void main(String args[]) {
        StartThreadTwice t1 = new StartThreadTwice();
        t1.start();
        t1.start();
    }
    
    /*
    running...
    Exception in thread "main" java.lang.IllegalThreadStateException
        at java.base/java.lang.Thread.start(Thread.java:793)
        at com.company.multithreading.exp3.StartThreadTwice.main(StartThreadTwice.java:19)
        
         */
}  
