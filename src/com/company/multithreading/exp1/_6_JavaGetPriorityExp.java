package com.company.multithreading.exp1;

/*
    6. public final int getPriority()
    
    It is used to check the priority of the thread. When a thread is created, some priority is assigned to it. 
    This priority is assigned either by the JVM or by the programmer explicitly while creating the thread.

 */

public class _6_JavaGetPriorityExp extends Thread {
    @Override
    public void run() {
        System.out.println("running thread name is:" + Thread.currentThread().getName());
    }

    public static void main(String args[]) throws InterruptedException {
        System.out.println("main() starts ... " + Thread.currentThread().getName());

        _6_JavaGetPriorityExp t1 = new _6_JavaGetPriorityExp();
        _6_JavaGetPriorityExp t2 = new _6_JavaGetPriorityExp();
        System.out.println("t1 thread priority : " + t1.getPriority());
        System.out.println("t2 thread priority : " + t2.getPriority());
        t1.start();
        t2.start();

        Thread.sleep(500); // some work in the main method

        System.out.println("main() ends ... " + Thread.currentThread().getName());
    }
    /*
        main() starts ... main
        t1 thread priority : 5
        t2 thread priority : 5
        running thread name is:Thread-0
        running thread name is:Thread-1
        main() ends ... main
     */
}  
