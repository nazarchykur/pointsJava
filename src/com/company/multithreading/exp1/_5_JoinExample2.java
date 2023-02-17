package com.company.multithreading.exp1;

/*
    public final void join(). 
        Цей метод призупинить виконання поточного потоку до тих пір, поки інший потік не закінчить виконання. 
        Якщо потік уривається, кидається InterruptedException.
    
    public final synchronized void join(long millis): 
        Цей метод призупинить виконання поточного потоку на вказаний час у мілісекундах. Виконання цього методу залежить 
        від реалізації ОС, тому Java не гарантує, що поточний потік чекатиме на вказаний вами час.
    
    public final synchronized void join(long millis, int nanos): 
        Цей метод призупинить виконання поточного потоку до тих пір, поки інший потік не закінчить своє виконання на 
        певний час в мілісекундах плюс наносекундах.

 */

public class _5_JoinExample2 {

    public static void main(String[] args) {
        System.out.println("main() starts ... " + Thread.currentThread().getName());

        Thread t1 = new Thread(new MyRunnable(), "t1");
        Thread t2 = new Thread(new MyRunnable(), "t2");
        Thread t3 = new Thread(new MyRunnable(), "t3");

        t1.start();

        //стартуємо другий потік тільки після 2-секундного очікування першого потоку (або коли він помре/закінчить виконання)
        try {
            t1.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();

        //стартуємо 3 потік тільки після того, як 1 потік закінчить своє виконання
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t3.start();

        //Даємо всім потокам можливість закінчити виконання перед тим, як програма (головний потік) закінчить своє виконання
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main() ends ... " + Thread.currentThread().getName());
        
        System.out.println("Усі потоки відпрацювали, завершуємо програму");
    }
    
    /*
        main() starts ... main
        Потік розпочав роботу: t1
        Потік розпочав роботу: t2
        Потік відпрацював:t1
        Потік розпочав роботу: t3
        Потік відпрацював:t2
        Потік відпрацював:t3
        main() ends ... main
        Усі потоки відпрацювали, завершуємо програму

     */

}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Потік розпочав роботу: " + Thread.currentThread().getName());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Потік відпрацював:" + Thread.currentThread().getName());
    }

}