package com.company.multithreading;

/*
    19. public void interrupt()

    This method of a thread is used to interrupt the currently executing thread. This method can only be called when 
    the thread is in sleeping or waiting state.
    
    But if the thread is not in the sleeping or waiting state, then the interrupt() method will not interrupt the 
    thread but will set the interrupt flag to true.
        
 */
public class _19_InterruptExp1 extends Thread {
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("javatpoint");
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread interrupted..." + e);

        }
    }

    public static void main(String args[]) {
        _19_InterruptExp1 thread1 = new _19_InterruptExp1();
        thread1.start();
        try {
            thread1.interrupt();
        } catch (Exception e) {
            System.out.println("Exception handled " + e);
        }
    }
    
    /*
    
    Exception in thread "Thread-0" java.lang.RuntimeException: Thread interrupted...java.lang.InterruptedException: sleep interrupted
	at com.company.multithreading._19_InterruptExp1.run(_19_InterruptExp1.java:19)
	
     */
}    
