package com.company.multithreading.exp5;

/*
    Метод join()
    
    Метод join() в Java надається класом java.lang.Thread, який дозволяє одному потоку чекати, поки інший потік завершить 
    своє виконання. Припустимо, що th буде об’єктом класу Thread, потік якого зараз виконує своє виконання, тоді th.join(); 
    заява гарантує, що th завершується до того, як програма виконає наступний оператор. Коли існує більше одного потоку, 
    який викликає метод join(), це призводить до перевантаження методу join(), що дозволяє розробнику або програмісту 
    згадати період очікування. Однак, подібно до методу sleep() у Java, метод join() також залежить від операційної 
    системи щодо часу, тому ми не повинні вважати, що метод join() чекає рівно часу, який ми згадуємо в параметрах. 
    Нижче наведено три перевантажені методи join().
    

 */

public class ThreadJoin extends Thread {
    // overriding the run method  
    public void run() {
        for (int j = 0; j < 2; j++) {
            try {
                // sleeping the thread for 300 milliseconds  
                Thread.sleep(300);
                System.out.println("The current thread name is: " + Thread.currentThread().getName());
            } catch (Exception e) { // catch block for catching the raised exception  
                System.out.println("The exception has been caught: " + e);
            }
            System.out.println(j);
        }
    }
}

class ThreadJoinExample {
    // main method  
    public static void main(String argvs[]) {

        // creating 3 threads  
        ThreadJoin th0 = new ThreadJoin();
        ThreadJoin th1 = new ThreadJoin();
        ThreadJoin th2 = new ThreadJoin();

        // thread th0 starts  
        th0.start();

        // starting the second thread after when the first thread th0 has ended or died.  
        try {
            System.out.println("The current thread name is: " + Thread.currentThread().getName());

            // invoking the join() method   
            th0.join();
        } catch (Exception e) { // catch block for catching the raised exception 
            System.out.println("The exception has been caught " + e);
        }

        
        // thread th2 starts  
        th2.start();

        // starting the th1 thread after when the thread th2 has ended or died.  
        try {
            System.out.println("The current thread name is: " + Thread.currentThread().getName());
            th2.join();
        } catch (Exception e) {  // catch block for catching the raised exception  
            System.out.println("The exception has been caught " + e);
        }

        // thread th1 starts  
        th1.start();
    }
    
    /*
        The current thread name is: main
        The current thread name is: Thread-0
        0
        The current thread name is: Thread-0
        1
        The current thread name is: main
        The current thread name is: Thread-2   // <= starting the second thread th2 after when the first thread th0 has ended or died. 
        0
        The current thread name is: Thread-2
        1
        The current thread name is: Thread-1   // <= starting the th1 thread after when the thread th2 has ended or died.
        0
        The current thread name is: Thread-1
        1
     */
}  
