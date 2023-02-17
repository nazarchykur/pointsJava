package com.company.multithreading.exp1;

/*
    9. public final void setName()
    
    This method changes the name of the thread.
 */
public class _9_SetNameExample extends Thread {
    @Override
    public void run() {
        System.out.println("running...");
    }

    public static void main(String args[]) {
        _9_SetNameExample thread1 = new _9_SetNameExample();
        _9_SetNameExample thread2 = new _9_SetNameExample();
        thread1.start();
        thread2.start();
        thread1.setName("super thread");
        thread2.setName("Great learning");
        System.out.println("After changing name of thread1: " + thread1.getName());
        System.out.println("After changing name of thread2: " + thread2.getName());
    }
    /*
        running...
        running...
        After changing name of thread1: super thread
        After changing name of thread2: Great learning
     */
}