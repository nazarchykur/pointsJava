package com.company.multithreading.exp6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/*
    ThreadPool = Пул потоків Java
    
    Пул потоків Java представляє групу робочих потоків, які очікують виконання завдання та багато разів повторно використовуються.
    
    У випадку пулу потоків створюється група потоків фіксованого розміру. Потік із пулу потоків витягується та призначається 
    завдання постачальником послуг. Після завершення завдання потік знову міститься в пулі потоків.
    
    
    Ризики, пов’язані з пулами потоків:
        > Deadlock = взаємоблокування: відомий факт, що взаємоблокування може виникнути в будь-якій програмі, яка 
            передбачає багатопотоковість, а пул потоків представляє інший сценарій deadlock. Розглянемо сценарій, коли 
            всі потоки, які виконуються, очікують результатів від потоків, які заблоковані та очікують у черзі через 
            відсутність потоків для виконання.

        > Thread Leakage = Витік потоків: витік потоків відбувається, коли потік видаляється з пулу для виконання завдання, 
            але не повертається до нього після завершення завдання. Наприклад, коли потік генерує виняток, а клас пулу 
            не в змозі зловити цей виняток, тоді потік завершує роботу та зменшує розмір пулу потоків на 1. Якщо одне і 
            те ж повторюється кілька разів, то є хороші шанси, що пул стане порожнім, і, отже, в пулі не буде потоків, 
            доступних для виконання інших запитів.
    
        > Resource Thrashing = Викидання ресурсів: багато часу витрачається на перемикання контексту між потоками, коли 
            розмір пулу потоків дуже великий. Щоразу, коли потоків більше, ніж оптимальна кількість, це може спричинити 
            проблему голодування, що призводить до вичерпання ресурсів.



    Пункти, які слід пам’ятати:
        > Не ставте в чергу завдання, які одночасно очікують на результати, отримані від інших завдань. Це може призвести 
            до тупикової ситуації, як пояснювалося вище.
        
        > Необхідно бути обережним, коли для операції використовуються нитки, які є довговічними. Це може призвести до 
            вічного очікування потоку і, нарешті, призведе до витоку ресурсу.
        
        > Зрештою, пул потоків має бути закрито явно. Якщо цього не відбувається, то програма продовжує виконуватися і 
            ніколи не закінчується. Викличте метод shutdown() у пулі потоків, щоб завершити роботу виконавця. Зауважте, 
            що якщо хтось спробує надіслати інше завдання виконавцю після завершення роботи, це викличе виняткову 
            ситуацію RejectedExecutionException.
        
        > Потрібно розуміти завдання, щоб ефективно налаштувати пул потоків. Якщо задані завдання контрастні, то слід 
            шукати пули для виконання різних різновидів завдань, щоб правильно їх налаштувати.
        
        > Щоб зменшити ймовірність запуску JVM з пам’яті, можна контролювати максимальну кількість потоків, які можуть 
            працювати в JVM. Пул потоків не може створювати нові потоки після досягнення максимального ліміту.
        
        > Пул потоків може використовувати той самий використаний потік, якщо потік завершив своє виконання. Таким чином, 
            економляться час і ресурси, що використовуються для створення нового потоку.



    Налаштування пулу потоків
        Точний розмір пулу потоків визначається кількістю доступних процесорів і типом завдань, які мають виконувати потоки. 
        Якщо система має процесори P, які мають лише процеси типу обчислень, тоді максимальний розмір пулу потоків 
        P або P + 1 забезпечує максимальну ефективність. Однак завданням може знадобитися чекати вводу-виводу, і в такому 
        сценарії потрібно брати до уваги співвідношення часу очікування (W) і часу обслуговування (S) для запиту; 
        в результаті чого максимальний розмір пулу P * (1 + W / S) для максимальної ефективності.
    
    
    Висновок
        Пул потоків є дуже зручним інструментом для організації програм, особливо на стороні сервера. З точки зору 
        концепції, пул потоків дуже простий для розуміння. Однак при роботі з пулом потоків, можливо, доведеться 
        розглянути багато проблем. Це тому, що пул потоків пов’язаний з деякими ризиками

 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);  //creating a pool of 2 threads  
        for (int i = 1; i <= 5; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);  //calling execute method of ExecutorService  
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
            // doing some work
        }

        System.out.println("Finished all threads");
    }
}

class WorkerThread implements Runnable {
    private String message;

    public WorkerThread(String s) {
        this.message = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " (Start) message = " + message);
        processMessage();  //call processMessage() that sleeps the thread for 2 seconds  
        System.out.println(Thread.currentThread().getName() + " (End)");  //prints thread name  
    }

    private void processMessage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}  