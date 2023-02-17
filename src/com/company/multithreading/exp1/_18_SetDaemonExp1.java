package com.company.multithreading.exp1;

/*
    18. public final void setDaemon(boolean on)
    
    This method of a thread is used to identify or mark the thread either daemon or a user thread. The JVM automatically 
    terminates this thread when all the user threads die.
    
    This thread method must run before the start of the execution of the thread.
    
    
    
    Потоки користувача мають високий пріоритет. JVM чекатиме, поки будь-який потік користувача виконає своє завдання, 
    перш ніж припинити його роботу.

    З іншого боку, потоки демона є низькопріоритетними потоками, єдиною роллю яких є надання послуг потокам користувачів.
    
    Оскільки потоки демонів призначені для обслуговування потоків користувачів і потрібні лише під час роботи потоків 
    користувачів, вони не перешкоджатимуть виходу JVM після того, як усі потоки користувача завершать своє виконання.
    
    Ось чому нескінченні цикли, які зазвичай існують у потоках демонів, не викличуть проблем, оскільки будь-який код, 
    включаючи блоки finally , не буде виконано після того, як усі потоки користувача завершать своє виконання. 
    З цієї причини потоки демонів не рекомендуються для завдань введення-виведення.

    Однак із цього правила є винятки. Погано розроблений код у потоках демона може перешкодити виходу JVM. Наприклад, 
    виклик Thread.join() у запущеному потокі демона може заблокувати завершення роботи програми.
    
    Створення потоку демона
        NewThread daemonThread = new NewThread();
        daemonThread.setDaemon(true);
        daemonThread.start();
    

    Метод setDaemon() можна викликати лише після того, як об’єкт Thread було створено, а потік не було запущено. 
    Спроба викликати setDaemon() під час роботи потоку призведе до виключення IllegalThreadStateException :
        @Test(expected = IllegalThreadStateException.class)
        public void whenSetDaemonWhileRunning_thenIllegalThreadStateException() {
            NewThread daemonThread = new NewThread();
            daemonThread.start();
            daemonThread.setDaemon(true);
        }
    
*/

public class _18_SetDaemonExp1 extends Thread {
    public void run() {
        if (Thread.currentThread().isDaemon()) {
            System.out.println("daemon thread work");
        } else {
            System.out.println("user thread work");
        }
    }

    public static void main(String[] args) {
        _18_SetDaemonExp1 thread1 = new _18_SetDaemonExp1();
        _18_SetDaemonExp1 thread2 = new _18_SetDaemonExp1();
        _18_SetDaemonExp1 thread3 = new _18_SetDaemonExp1();
        thread1.setDaemon(true);
        thread1.start();
        thread2.setDaemon(true);
        thread2.start();
        thread3.start();
    }
    
    /*
        daemon thread work
        user thread work
        daemon thread work
     */
} 
