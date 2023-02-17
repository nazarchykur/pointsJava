package com.company.multithreading;

/*
    5. public void join()
    
    It causes the current thread to block until the second thread terminates or the specified amount of milliseconds passes.
 */

public class _5_JoinExample1 extends Thread {
    public void run() {
        for (int i = 1; i <= 4; i++) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        System.out.println("some work in main starts ... " + Thread.currentThread().getName());
        
        _5_JoinExample1 thread1 = new _5_JoinExample1();
        _5_JoinExample1 thread2 = new _5_JoinExample1();
        _5_JoinExample1 thread3 = new _5_JoinExample1();
        
        thread1.start();
        try {
            thread1.join();  // <= When the join() method is invoked, the current thread stops its execution and the thread goes into the wait state.
        } catch (Exception e) {
            System.out.println(e);
        }
        
        thread2.start();
        thread3.start();
        
        System.out.println("some work in main ends ... " + Thread.currentThread().getName());

        /*
            some work in main starts ... main
            1
            2
            3
            4
            some work in main ends ... main
            1
            1
            2
            2
            3
            3
            4
            4

         */
    }
}  