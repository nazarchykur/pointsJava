package com.company.multithreading.exp1;

public class _11_IsAliveExp extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(300);
            System.out.println("is run() method isAlive " + Thread.currentThread().isAlive());
        } catch (InterruptedException ie) {
        }
    }

    public static void main(String[] args) {
        _11_IsAliveExp thread1 = new _11_IsAliveExp();
        System.out.println("before starting thread isAlive: " + thread1.isAlive());
        thread1.start();
        System.out.println("after starting thread isAlive: " + thread1.isAlive());
    }
    
    /*
        before starting thread isAlive: false
        after starting thread isAlive: true
        is run() method isAlive true
     */
}  
