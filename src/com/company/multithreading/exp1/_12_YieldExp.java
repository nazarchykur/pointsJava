package com.company.multithreading.exp1;

/*
    12. public static void yield()

    This method pauses the execution of the current thread to execute other threads temporarily.
    
    Статичний метод Thread.yield() повертає даний потік, в стані runnable, для того, щоб поступитися місцем іншому потоку.
    
    Процесор постійно перемикається між потоками. Кожному потоку виділяється невеликий шматочок процесорного часу, 
    який називають квантом. Коли цей час спливає – процесор перемикається на іншу нитку та починає виконувати її команди. 
    Виклик методу  Thread.yield() дозволяє достроково завершити квант часу поточної нитки (потоку) або, іншими словами, 
    перемикає процесор на наступну нитку.
    
    — Необхідність у цьому виникає не часто. Виклик  yield  призводить до того, що «наша нитка достроково завершує хід», 
    і наступна за  yield  команда розпочнеться з повного кванта часу. Значить шанси, що її перервуть менше. 
    Особливо якщо вона невелика (за часом). Такий підхід можна використовувати для оптимізації деяких процесів.

    Ще можу додати, що метод  Thread.sleep(0)  працює практично так само.
    

 */

public class _12_YieldExp extends Thread {
    public void run() {
        for (int i = 0; i < 3; i++)
            System.out.println(i + " run() " + Thread.currentThread().getName() + " in control");
    }

    public static void main(String[] args) {
        System.out.println("main() starts ... " + Thread.currentThread().getName());

        _12_YieldExp thread1 = new _12_YieldExp();
        _12_YieldExp thread2 = new _12_YieldExp();
        thread1.start();
        thread2.start();
        for (int i = 0; i < 3; i++) {
            thread1.yield();
            System.out.println(i + " main() " + Thread.currentThread().getName() + " in control");
        }

        System.out.println("main() ends ... " + Thread.currentThread().getName());

    }
    
    /*
        main() starts ... main
        0 run() Thread-0 in control
        0 run() Thread-1 in control
        1 run() Thread-0 in control
        1 run() Thread-1 in control
        2 run() Thread-0 in control
        2 run() Thread-1 in control
        0 main() main in control
        1 main() main in control
        2 main() main in control
        main() ends ... main
        
     */
}  