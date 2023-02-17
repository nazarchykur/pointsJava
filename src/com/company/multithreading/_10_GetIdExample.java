package com.company.multithreading;

public class _10_GetIdExample extends Thread {
    @Override
    public void run() {
        System.out.println("running...");
    }

    public static void main(String args[]) {
        _10_GetIdExample thread1 = new _10_GetIdExample();
        System.out.println("Name of thread1: " + thread1.getName());
        System.out.println("Id of thread1: " + thread1.getId());
        thread1.start();
    }
    /*
        Name of thread1: Thread-0
        Id of thread1: 15
        running...
        
     */
}
