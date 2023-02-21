package com.company.multithreading.exp4;

/*
    What if we call Java run() method directly instead start() method?
    
        > Each thread starts in a separate call stack.
        > Invoking the run() method from the main thread, the run() method goes onto the current call stack rather than 
            at the beginning of a new call stack.

 */

public class CallRun1 extends Thread {
    @Override
    public void run() {
        System.out.println("running...");
    }

    public static void main(String[] args) {
        CallRun1 t1 = new CallRun1();
        t1.run(); //fine, but does not start a separate call stack  
    }
    
    /*
        running...
     */
}

class CallRun2 extends Thread {
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

    public static void main(String[] args) {
        CallRun2 t1 = new CallRun2();
        CallRun2 t2 = new CallRun2();

        t1.run();
        t2.run();
    }
    
    /*
        As we can see in the above program that there is no context-switching because here t1 and t2 will be treated as 
        normal object not thread object.

            1
            2
            3
            4
            1
            2
            3
            4

     */
}  