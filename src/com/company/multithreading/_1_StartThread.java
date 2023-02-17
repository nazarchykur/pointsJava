package com.company.multithreading;

public class _1_StartThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String args[]) {
        _1_StartThread thread1 = new _1_StartThread();
        thread1.start(); // Output: Thread is running...
    }
}

/*
    1. public void start()
    
    It starts the execution of the thread and then calls the run() on this Thread object.

 */