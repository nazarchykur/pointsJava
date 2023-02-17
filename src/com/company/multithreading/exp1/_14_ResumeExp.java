package com.company.multithreading.exp1;

/*
14. public final void resume()

This method is used to resume the suspended thread. It is only used with the suspend() method.

 */
public class _14_ResumeExp extends Thread {
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
        _14_ResumeExp thread1 = new _14_ResumeExp();
        _14_ResumeExp thread2 = new _14_ResumeExp();
        _14_ResumeExp thread3 = new _14_ResumeExp();
        thread1.start();
        thread2.start();
        thread2.suspend(); // deprecated
        thread3.start();
        thread2.resume(); // deprecated
    }
    /*
        Thread-0
        Thread-1
        1
        Thread-2
        1
        1
        Thread-1
        2
        Thread-2
        Thread-0
        2
        2

     */
}  