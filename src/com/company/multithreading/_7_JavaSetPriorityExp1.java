package com.company.multithreading;

/*
    7. public final void setPriority()
    
    This method is used to change the priority of the thread. The priority of every thread is represented by the 
    integer number from 1 to 10. The default priority of a thread is 5.

 */
public class _7_JavaSetPriorityExp1 extends Thread {
    @Override
    public void run() {
        System.out.println("Priority of thread is: " + Thread.currentThread().getPriority());
    }

    public static void main(String args[]) {
        _7_JavaSetPriorityExp1 t1 = new _7_JavaSetPriorityExp1();
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
    }
    
    /*

        public static final int MIN_PRIORITY = 1; The minimum priority that a thread can have.
        public static final int NORM_PRIORITY = 5; The default priority that is assigned to a thread.
        public static final int MAX_PRIORITY = 10; The maximum priority that a thread can have.
        
     */
} 