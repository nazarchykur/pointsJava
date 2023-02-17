package com.company.multithreading;

/*
    17. public final boolean isDaemon()
    
    This thread method will check if the thread is a daemon thread or not. If it is a daemon thread, then it will return 
    true else, it will return false.
    
    For those who don’t know about a daemon thread, a daemon thread is a thread that will not stop the Java Virtual Machine 
    (JVM) from exiting when the program is ended, but the thread is still running.

 */
public class _17_IsDaemonExp extends Thread {
    public void run() {
        //checking for daemon thread    
        if (Thread.currentThread().isDaemon()) {
            System.out.println("daemon thread work");
        } else {
            System.out.println("user thread work");
        }
    }

    public static void main(String[] args) {
        _17_IsDaemonExp thread1 = new _17_IsDaemonExp();
        _17_IsDaemonExp thread2 = new _17_IsDaemonExp();
        _17_IsDaemonExp thread3 = new _17_IsDaemonExp();
        thread1.setDaemon(true);
        thread1.start();
        thread2.start();
        thread3.start();
    }
    
    /*
        daemon thread work
        user thread work
        user thread work

     */
}  
