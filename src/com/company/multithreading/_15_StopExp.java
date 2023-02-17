package com.company.multithreading;

/*
    15. public final void stop()
    
    As the name suggests, this method is used to stop the currently running thread. Remember, once the thread execution 
    is stopped, it cannot be restarted.

 */
public class _15_StopExp extends Thread {
    public void run() {
        for (int i = 1; i < 3; i++) {
            try {
                sleep(500);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        _15_StopExp thread1 = new _15_StopExp();
        _15_StopExp thread2 = new _15_StopExp();
        _15_StopExp thread3 = new _15_StopExp();
        thread1.start();
        thread2.start();
        thread3.stop();
        System.out.println("Thread thread3 is stopped");
    }
    
    /*
        Thread thread3 is stopped
        Thread-0
        Thread-1
        1
        1
        Thread-1
        2
        Thread-0
        2

     */
} 
