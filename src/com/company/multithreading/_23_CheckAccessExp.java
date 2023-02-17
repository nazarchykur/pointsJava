package com.company.multithreading;

/*
    23. public final void checkAccess()
    
    This thread method identifies if the current thread has permission to modify the thread.
 */

public class _23_CheckAccessExp extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " finished executing");
    }

    public static void main(String arg[]) throws InterruptedException, SecurityException {
        _23_CheckAccessExp thread1 = new _23_CheckAccessExp();
        _23_CheckAccessExp thread2 = new _23_CheckAccessExp();
        thread1.start();
        thread2.start();
        thread1.checkAccess(); // deprecated
        System.out.println(thread1.getName() + " has access");
        thread2.checkAccess(); // deprecated
        System.out.println(thread2.getName() + " has access");
    }
    
    /*
        Thread-1 finished executing
        Thread-0 has access
        Thread-0 finished executing
        Thread-1 has access
     */
}  
