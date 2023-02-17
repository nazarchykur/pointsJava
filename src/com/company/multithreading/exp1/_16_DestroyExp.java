package com.company.multithreading.exp1;

/*
16. public void destroy()

This thread method destroys the thread group as well as its subgroups.

 */

public class _16_DestroyExp extends Thread {
    _16_DestroyExp(String threadname, ThreadGroup tg) {
        super(tg, threadname);
        start();
    }

    public void run() {
        for (int i = 0; i < 2; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println("Exception encounterted");
            }
        }
        System.out.println(Thread.currentThread().getName() + " finished executing");
    }

    public static void main(String arg[]) throws InterruptedException, SecurityException {
        ThreadGroup g1 = new ThreadGroup("Parent thread");
        ThreadGroup g2 = new ThreadGroup(g1, "child thread");
        _16_DestroyExp thread1 = new _16_DestroyExp("Thread-1", g1);
        _16_DestroyExp thread2 = new _16_DestroyExp("Thread-2", g1);
        thread1.join();
        thread2.join();
        g2.destroy(); // deprecated
        System.out.println(g2.getName() + " destroyed");
        g1.destroy(); // deprecated
        System.out.println(g1.getName() + " destroyed");
    }
    
    /*
        Thread-1 finished executing
        Thread-2 finished executing
        child thread destroyed
        Parent thread destroyed

     */
} 
