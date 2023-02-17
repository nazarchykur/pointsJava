package com.company.multithreading.exp1;

/*
    3. public static void sleep()
    
    This blocks the currently running thread for the specified amount of time.
 */

public class _3_SleepExp1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        System.out.println("some work in main starts ..");
        _3_SleepExp1 thread1 = new _3_SleepExp1();
        _3_SleepExp1 thread2 = new _3_SleepExp1();
        thread1.start();
        thread2.start();
        System.out.println("some work in main ends..");
        
        /*
            some work in main starts ..
            some work in main ends..
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
