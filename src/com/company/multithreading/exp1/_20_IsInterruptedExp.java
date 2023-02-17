package com.company.multithreading.exp1;

/*
    20. public boolean isInterrupted()  

    This thread method is used to test whether the thread is interrupted or not. It will return the value of the internal 
    flag as true or false, i.e. if the thread is interrupted, it will return true else, it will return false.

 */
public class _20_IsInterruptedExp extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("doing task....: " + i);
        }
    }

    public static void main(String args[]) throws InterruptedException {
        _20_IsInterruptedExp thread1 = new _20_IsInterruptedExp();
        _20_IsInterruptedExp thread2 = new _20_IsInterruptedExp();
        thread1.start();
        thread2.start();
        System.out.println("is thread interrupted..: " + thread1.isInterrupted());
        System.out.println("is thread interrupted..: " + thread2.isInterrupted());
        thread1.interrupt();
        System.out.println("is thread interrupted..: " + thread1.isInterrupted());
        System.out.println("is thread interrupted..: " + thread2.isInterrupted());
    }
    
    /*
        doing task....: 1
        doing task....: 2
        doing task....: 3
        doing task....: 1
        doing task....: 2
        doing task....: 3
        is thread interrupted..: false
        is thread interrupted..: false
        is thread interrupted..: true
        is thread interrupted..: false

     */
} 
