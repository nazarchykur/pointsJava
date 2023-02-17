package com.company.multithreading.exp1;

/*
    22. public static int activeCount()

    This method of the thread is used to return the no. of active threads in the currently executing thread’s thread group.
    
    The number returned by this threading method is only an estimate number as the number of threads dynamically changes 
    while this method traverses internal data structures.

 */

public class _22_ActiveCountExp extends Thread {
    _22_ActiveCountExp(String threadname, ThreadGroup tg) {
        super(tg, threadname);
        start();
    }

    public void run() {
        System.out.println("running thread name is:" + Thread.currentThread().getName());
    }

    public static void main(String arg[]) {
        ThreadGroup g1 = new ThreadGroup("parent thread group");
        _22_ActiveCountExp thread1 = new _22_ActiveCountExp("Thread-1", g1);
        _22_ActiveCountExp thread2 = new _22_ActiveCountExp("Thread-2", g1);
        System.out.println("number of active thread: " + g1.activeCount());
    }
    
    /*
        running thread name is:Thread-1
        running thread name is:Thread-2
        number of active thread: 2
     */
}  
