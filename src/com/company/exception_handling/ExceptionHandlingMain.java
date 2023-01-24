package com.company.exception_handling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class ExceptionHandlingMain {
}
/*
=======================================================================================================================
=========================================      Theory      ============================================================
=======================================================================================================================
 */
/*
    Difference between Checked and Unchecked Exceptions
    
        1) Checked Exception
        The classes that directly inherit the Throwable class except RuntimeException and Error are known as checked 
        exceptions. For example, IOException, SQLException, etc. Checked exceptions are checked at compile-time.
        
        2) Unchecked Exception
        The classes that inherit the RuntimeException are known as unchecked exceptions. 
        For example, ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException, etc. 
        Unchecked exceptions are not checked at compile-time, but they are checked at runtime.
        
        3) Error
        Error is irrecoverable. Some example of errors are OutOfMemoryError, VirtualMachineError, AssertionError etc.

        
        +---------+---------------------------------------------------------------------------------------------------+
        | Keyword | Description                                                                                       |
        +---------+---------------------------------------------------------------------------------------------------+
        | try     | The "try" keyword is used to specify a block where we should place an exception code.             |
        |         | It means we can't use try block alone. The try block must be followed by either catch or finally. |
        +---------+---------------------------------------------------------------------------------------------------+
        | catch   | The "catch" block is used to handle the exception.                                                |
        |         | It must be preceded by try block which means we can't use catch block alone.                      |
        |         | It can be followed by finally block later.                                                        |
        +---------+---------------------------------------------------------------------------------------------------+
        | finally | The "finally" block is used to execute the necessary code of the program.                         |
        |         | It is executed whether an exception is handled or not.                                            |
        +---------+---------------------------------------------------------------------------------------------------+
        | throw   | The "throw" keyword is used to throw an exception.                                                |
        +---------+---------------------------------------------------------------------------------------------------+
        | throws  | The "throws" keyword is used to declare exceptions.                                               |
        |         | It specifies that there may occur an exception in the method.                                     |
        |         | It doesn't throw an exception. It is always used with method signature.                           |
        +---------+---------------------------------------------------------------------------------------------------+



Here's the syntax of try...catch block:

        try {
          // code that may raise exception  
        } catch(Exception e) {
          // code
        }
        
        
The basic syntax of finally block is:      
        +------------------------------------+---------------------------------------+
        | try {                              |  try {                                |
        |   // code that may raise exception |    //code that may throw an exception |
        | } catch (ExceptionType1 e1) {      |  } finally {                          |
        |   // catch block                   |    // finally block always executes   |
        | } finally {                        |  }                                    |
        |   // finally block always executes |                                       |
        | }                                  |                                       |
        +------------------------------------+---------------------------------------+
        
     
     
Java Multi-catch block
    A try block can be followed by one or more catch blocks. Each catch block must contain a different exception handler. 
    So, if you have to perform different tasks at the occurrence of different exceptions, use java multi-catch block.

Points to remember
    > At a time only one exception occurs and at a time only one catch block is executed.
    > All catch blocks must be ordered from most specific to most general, i.e. catch for ArithmeticException must come 
        before catch for Exception.
            
Let's see a simple example of java multi-catch block.

        try {    
            int a[]=new int[5];    
            a[5]=30/0;    
        } catch(ArithmeticException e) {  
            System.out.println("Arithmetic Exception occurs");  
        } catch(ArrayIndexOutOfBoundsException e) {  
            System.out.println("ArrayIndexOutOfBounds Exception occurs");  
        } catch(Exception e) {  
            System.out.println("Parent Exception occurs");  
        }        
             
           System.out.println("rest of the code");    
        }  
 */


/*
=======================================================================================================================
=======================================      Checked Exceptions      ==================================================
=======================================================================================================================
 */

/*

Checked Exceptions

    The checked exception is an exception that is checked by the compiler during the compilation process to confirm 
    whether the exception is handled by the programmer or not. If it is not handled, the compiler displays a 
    compilation error using built-in classes.
    
    The checked exceptions are generally caused by faults outside of the code itself like missing resources, 
    networking errors, and problems with threads come to mind.
    
    The following are a few built-in classes used to handle checked exceptions in java.
        > IOException
        > FileNotFoundException
        > ClassNotFoundException
        > SQLException
        > DataAccessException
        > InstantiationException
        > UnknownHostException

    🔔 In the exception class hierarchy, the checked exception classes are the direct children of the Exception class.
    
    The checked exception is also known as a compile-time exception.
 */

/*

If ClassNotFoundException or FileNotFoundException are thrown (occur) in a method, the developer must indicate them in 
the method declaration. These are checked exceptions. 
    
    This is how it usually looks:

        public static void method1() throws ClassNotFoundException, FileNotFoundException
        public static void main() throws IOException
        public static void main() // Doesn't throw any exceptions

        
        For the program to compile, the method that calls method1 in the example below must do one of two things: 
            > either catch these exceptions or rethrow them (to the caller), 
            > indicating the rethrown exceptions in its declaration.
        
        
        Again. If your main method needs to call a method whose declaration contains 'throws FileNotFoundException, …', 
        then you need to do one of two things:
            1) Catch FileNotFoundException, …
                You must wrap the code calling the unsafe method in a try-catch block.
            
            2) Don't catch FileNotFoundException, …
                You must add these exceptions to the throws list of your main method.

            
            Examples of checked exceptions
                    public static void main(String[] args) {
                        method1();
                    }
                    
                    public static void method1() throws FileNotFoundException, ClassNotFoundException {
                        //Throws FileNotFoundException if the file doesn't exist
                        FileInputStream fis = new FileInputStream("C2:\badFileName.txt");
                    }
                    
            The code in this example won't compile, because the main method calls method1(), 
            which throws exceptions that have to be caught.
            
            
            To make it compile, we need to add exception handling to the main method. 
            You can do this in one of two ways:
            
                Option 1: We simply rethrow the exception (to the caller):
                    
                        public static void main(String[] args)  throws FileNotFoundException, ClassNotFoundException {
                            method1();
                        }
                        
                        public static void method1() throws FileNotFoundException, ClassNotFoundException {
                            //Throws FileNotFoundException if the file doesn't exist
                            FileInputStream fis = new FileInputStream("C2:\badFileName.txt");
                        }
                        
                        
                And here we catch it with a try-catch:
                Option 2: Catch the exception:
                
                        public static void main(String[] args) {
                            try {
                                method1();
                            } catch(Exception e) {
                            }
                        }
                        
                        public static void method1() throws FileNotFoundException, ClassNotFoundException {
                            //Throws FileNotFoundException if the file doesn't exist
                            FileInputStream fis = new FileInputStream("C2:\badFileName.txt");
                        }   
           
      
      There is one more type of exception, the RuntimeException and classes that inherit it. 
      You don't need to catch them. These are unchecked exceptions. 
      They are considered difficult to predict. 
      You can deal with them in the same way, but you don't need to indicate them in a throws clause.
                              
 */

class _1_CheckedExceptions {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\User\\Desktop\\Today\\Sample.txt");
        try {
            FileReader fr = new FileReader(file);
        } catch (Exception e) {
            System.out.println(e); // java.io.FileNotFoundException: C:\Users\User\Desktop\Today\Sample.txt (No such file or directory)
        }

    }
}

/*
=======================================================================================================================
=====================================      Unchecked Exceptions      ==================================================
=======================================================================================================================
 */
/*
Unchecked Exceptions

    The unchecked exception is an exception that occurs at the time of program execution. 
    The unchecked exceptions are not caught by the compiler at the time of compilation.
    
    The unchecked exceptions are generally caused due to bugs such as logic errors, improper use of resources, etc.
    
    The following are a few built-in classes used to handle unchecked exceptions in java.
        > ArithmeticException
        > NullPointerException
        > NumberFormatException
        > ArrayIndexOutOfBoundsException
        > StringIndexOutOfBoundsException
    
    🔔 In the exception class hierarchy, the unchecked exception classes are the children of RuntimeException class, 
        which is a child class of Exception class.
    
    The unchecked exception is also known as a runtime exception.

 */

class _2_UncheckedException {
    public static void main(String[] args) {

        int list[] = {10, 20, 30, 40, 50};

        System.out.println(list[6]);        //ArrayIndexOutOfBoundsException
        // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 5
        //	at com.company.exception_handling.UncheckedException.main

        String msg = null;
        System.out.println(msg.length());    //NullPointerException 
        // Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "msg" is null
        //	at com.company.exception_handling.UncheckedException.main

        String name = "abc";
        int i = Integer.parseInt(name);        //NumberFormatException  
        // Exception in thread "main" java.lang.NumberFormatException: For input string: "abc"
        //	at java.base/java.lang.NumberFormatException.forInputString

    }
}

/*
=======================================================================================================================
=======================================   Java try-with-resources    ==================================================
=======================================================================================================================
 */

/*
Java try-with-resources
    The try-with-resources statement automatically closes all the resources at the end of the statement. 
    A resource is an object to be closed at the end of the program.
    
    Its syntax is:
            try (resource declaration) {
              // use of the resource
            } catch (ExceptionType e1) {
              // catch block
            }

            
Advantages of using try-with-resources:

        1. finally block not required to close the resource
            Before Java 7 introduced this feature, we had to use the finally block to ensure that the resource 
            is closed to avoid resource leaks.    

 */

class _3_1_TryWithResources {
    public static void main(String[] args) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            while ((line = br.readLine()) != null) {
                System.out.println("Line =>" + line);
            }
        } catch (IOException e) {
            System.out.println("IOException in try block =>" + e.getMessage()); // IOException in try block =>test.txt (No such file or directory)
        }
    }
}


class _3_2_CloseResourceUsingFinallyBlock {
    public static void main(String[] args) {
        BufferedReader br = null;
        String line;

        try {
            System.out.println("Entering try block");
            br = new BufferedReader(new FileReader("test.txt"));
            while ((line = br.readLine()) != null) {
                System.out.println("Line =>" + line);
            }
        } catch (IOException e) {
            System.out.println("IOException in try block =>" + e.getMessage());
        } finally {
            System.out.println("Entering finally block");
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.out.println("IOException in finally block =>" + e.getMessage());
            }

        }
        /*
            Entering try block
            IOException in try block =>test.txt (No such file or directory)
            Entering finally block
            
            
            
            As we can see from the above example, the use of finally block to clean up resources makes the code more complex.
            
            Notice the try...catch block in the finally block as well? This is because an IOException can also occur 
            while closing the BufferedReader instance inside this finally block so it is also caught and handled.
            
            The try-with-resources statement does automatic resource management. We need not explicitly close the 
            resources as JVM automatically closes them. This makes the code more readable and easier to write.

         */
    }
}
/*
    2. try-with-resources with multiple resources
    
        We can declare more than one resource in the try-with-resources statement by separating them with a semicolon ;
 */

class _3_3_TryWithMultipleResources {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new File("testRead.txt"));
             PrintWriter writer = new PrintWriter(new File("testWrite.txt"))) {
            while (scanner.hasNext()) {
                writer.print(scanner.nextLine());
            }
        }
    }
}

/*
Java 9 try-with-resources enhancement

    In Java 7, there is a restriction to the try-with-resources statement. 
    The resource needs to be declared locally within its block.
            try (Scanner scanner = new Scanner(new File("testRead.txt"))) {
              // code
            }
    
    If we declared the resource outside the block in Java 7, it would have generated an error message.
            Scanner scanner = new Scanner(new File("testRead.txt"));
            try (scanner) {
              // code
            }
            
    To deal with this error, Java 9 improved the try-with-resources statement so that the reference of the resource 
    can be used even if it is not declared locally. The above code will now execute without any compilation error.

 */

/*
=======================================================================================================================
==========================   Examples of handling exception in catch and finally blocks    ============================
=======================================================================================================================
 */

/*

When an exception occurr but not handled by the catch block
    
    Here, the code throws an exception however the catch block cannot handle it. 
    Despite this, the finally block is executed after the try block and then the program terminates abnormally.
    

 */

class _4_1_TestFinallyBlock {
    public static void main(String args[]) {
        try {
            System.out.println("Inside the try block");

            //below code throws divide by zero exception  
            int data = 25 / 0;
            System.out.println(data);
        }
        //cannot handle Arithmetic type exception  
        //can only accept Null Pointer type exception  
        catch (NullPointerException e) {
            System.out.println(e);
        }
        //executes regardless of exception occured or not   
        finally {
            System.out.println("finally block is always executed");
        }

        System.out.println("rest of the code...");
    }
    /*
        Inside the try block
        finally block is always executed
        Exception in thread "main" java.lang.ArithmeticException: / by zero

     */
}  

/*
When an exception occurs and is handled by the catch block
    
    Let's see the following example where the Java code throws an exception and the catch block handles the exception. 
    Later the finally block is executed after the try-catch block. Further, the rest of the code is also executed normally.
    
 */

class _4_2_TestFinallyBlock2 {
    public static void main(String args[]) {
        try {
            System.out.println("Inside try block");

            //below code throws divide by zero exception  
            int data = 25 / 0;
            System.out.println(data);
        }
        //handles the Arithmetic Exception / Divide by zero exception  
        catch (ArithmeticException e) {
            System.out.println("Exception handled");
            System.out.println(e);
        }
        //executes regardless of exception occured or not   
        finally {
            System.out.println("finally block is always executed");
        }

        System.out.println("rest of the code...");
    }
    
    /*
        Inside try block
        Exception handled
        java.lang.ArithmeticException: / by zero
        finally block is always executed
        rest of the code...
     */
}


/*
=======================================================================================================================
========================================   Java Exception Propagation    ==============================================
=======================================================================================================================
 */
/*
Java Exception Propagation

    An exception is first thrown from the top of the stack and if it is not caught, it drops down the call stack to 
    the previous method. If not caught there, the exception again drops down to the previous method, and so on 
    until they are caught or until they reach the very bottom of the call stack. This is called exception propagation.
    
 */
class _5_1_TestExceptionPropagation1 {
    void method_1() {
        System.out.println("inside method_1 first row");
        int data = 50 / 0;
        System.out.println("inside method_1 last row");
    }

    void method_2() {
        System.out.println("inside method_2 first row");
        method_1();
        System.out.println("inside method_2 last row");
    }

    void method_3() {
        System.out.println("inside method_3 first row");
        try {
            method_2();
        } catch (Exception e) {
            System.out.println("exception handled");
        }
        System.out.println("inside method_3 last row");
    }

    public static void main(String args[]) {
        _5_1_TestExceptionPropagation1 obj = new _5_1_TestExceptionPropagation1();
        System.out.println("inside main first row");
        obj.method_3();
        System.out.println("normal flow...");
        System.out.println("inside main last row");
    }
    
    /*
        inside main first row
        inside method_3 first row
        inside method_2 first row
        inside method_1 first row
        exception handled
        inside method_3 last row
        normal flow...
        inside main last row
     */
}

class _5_2_TestExceptionPropagation2 {
    void method_1() {
//        throw new IOException("device error"); //checked exception      //  => Compile Time Error
    }

    void method_2() {
        method_1();
    }

    void method_3() {
        try {
            method_2();
        } catch (Exception e) {
            System.out.println("exception handeled");
        }
    }

    public static void main(String args[]) {
        _5_2_TestExceptionPropagation2 obj = new _5_2_TestExceptionPropagation2();
        obj.method_3();
        System.out.println("normal flow");
    }
}  


/*
=======================================================================================================================
======================================     Java throw Exception      =================================================
=======================================================================================================================
 */

/*

Java throw Exception
    
    In Java, exceptions allows us to write good quality codes where the errors are checked at the compile time 
    instead of runtime and we can create custom exceptions making the code recovery and debugging easier.
    
    
Java throw keyword

    The Java throw keyword is used to throw an exception explicitly.

    We specify the exception object which is to be thrown. The Exception has some message with it that provides 
    the error description. These exceptions may be related to user inputs, server, etc.
    
    We can throw either checked or unchecked exceptions in Java by throw keyword. 
    It is mainly used to throw a custom exception.
     
    
    
    We can also define our own set of conditions and throw an exception explicitly using throw keyword. 
    For example, we can throw ArithmeticException if we divide a number by another number. 
    Here, we just need to set the condition and throw exception using throw keyword.
    
         > throw new exception_class("error message");  
         > throw new IOException("sorry device error");   
         
         
 */

/*
    Example 1: Throwing Unchecked Exception
    In this example, we have created a method named validate() that accepts an integer as a parameter. 
    If the age is less than 18, we are throwing the ArithmeticException otherwise print a message welcome to vote.

 */
class _6_1_TestThrow1 {
    //function to check if person is eligible to vote or not   
    public static void validate(int age) {
        if (age < 18) {
            //throw Arithmetic exception if not eligible to vote  
            throw new ArithmeticException("Person is not eligible to vote");
        } else {
            System.out.println("Person is eligible to vote!!");
        }
    }

    //main method  
    public static void main(String args[]) {
        //calling the function  
        validate(13); // Exception in thread "main" java.lang.ArithmeticException: Person is not eligible to vote
        System.out.println("rest of the code..."); // not printed
    }
} 

/*
Example 2: Throwing Checked Exception

Note: Every subclass of Error and RuntimeException is an unchecked exception in Java. 
    A checked exception is everything else under the Throwable class.

 */

class _6_2_TestThrow2 {
    //function to check if person is eligible to vote or not   
    public static void method() throws FileNotFoundException {
        FileReader file = new FileReader("C:\\Users\\Desktop\\abc.txt");
        BufferedReader fileInput = new BufferedReader(file);

        throw new FileNotFoundException();
    }

    //main method  
    public static void main(String args[]) {
        try {
            method();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("rest of the code...");
    }
    /*
        java.io.FileNotFoundException: C:\Users\Desktop\abc.txt (No such file or directory)
        ...
        rest of the code...
     */
}

/*
Example 3: Throwing User-defined Exception
 */

// class represents user-defined exception  
class _6_3_UserDefinedException extends Exception {
    public _6_3_UserDefinedException(String str) {
        // Calling constructor of parent Exception  
        super(str);
    }
}

// Class that uses above MyException  
class TestThrow3 {
    public static void main(String args[]) {
        try {
            // throw an object of user defined exception  
            throw new _6_3_UserDefinedException("This is user-defined exception");
        } catch (_6_3_UserDefinedException ude) {
            System.out.println("Caught the exception");
            // Print the message from MyException object  
            System.out.println(ude.getMessage());
        }
        /*
            Caught the exception
            This is user-defined exception
         */
    }
}   


/*
The above code throw an unchecked exception. Similarly, we can also throw unchecked and user defined exceptions.

Note: If we throw unchecked exception from a method, it is must to handle the exception or declare in throws clause.
 */


/*
=======================================================================================================================
=====================================     Java throws Exception      =================================================
=======================================================================================================================
 */

/*
Java throws keyword

    The Java throws keyword is used to declare an exception. It gives an information to the programmer that there may 
    occur an exception. So, it is better for the programmer to provide the exception handling code so that the normal 
    flow of the program can be maintained.
    
    Exception Handling is mainly used to handle the checked exceptions. If there occurs any unchecked exception such 
    as NullPointerException, it is programmers' fault that he is not checking the code before it being used.
    
    Syntax of Java throws:
            return_type method_name() throws exception_class_name{  
                //method code  
            } 
    
    Which exception should be declared?
        Answer: Checked exception only, because:
            > unchecked exception: under our control so we can correct our code.
            > error: beyond our control. For example, we are unable to do anything if there occurs VirtualMachineError or StackOverflowError.
            
            
    Advantage of Java throws keyword
        Now Checked Exception can be propagated (forwarded in call stack). 
        It provides information to the caller of the method about the exception.       
 */

class _7_1_TestThrows1 {
    void method_1() throws IOException {
        System.out.println("inside method_1 first row");
        throw new IOException("device error"); //checked exception
    }

    void method_2() throws IOException {
        System.out.println("inside method_2 first row");
        method_1();
        System.out.println("inside method_2 last row");

    }

    void method_3() {
        System.out.println("inside method_3 first row");
        try {
            method_2();
        } catch (Exception e) {
            System.out.println("exception handled");
        }
        System.out.println("inside method_3 last row");
    }

    public static void main(String args[]) {
        _7_1_TestThrows1 obj = new _7_1_TestThrows1();
        System.out.println("inside main first row");
        obj.method_3();
        System.out.println("normal flow...");
        System.out.println("inside main last row");
    }
    
    /*
        inside main first row
        inside method_3 first row
        inside method_2 first row
        inside method_1 first row
        exception handled
        inside method_3 last row
        normal flow...
        inside main last row
        
        
        Rule: If we are calling a method that declares an exception, we must either caught or declare the exception.
     */
}
/*
 There are two cases:
            Case 1: We have caught the exception i.e. we have handled the exception using try/catch block.
            Case 2: We have declared the exception i.e. specified throws keyword with the method.
            
   
   Case 1: Handle Exception Using try-catch block
        In case we handle the exception, the code will be executed fine whether exception occurs during the program or not.
         
 */

class _7_2_HandleExceptionUsingTryCatchBlock {
    void method() throws IOException {
        throw new IOException("device error");
    }
}

class TestThrows2 {
    public static void main(String args[]) {
        try {
            _7_2_HandleExceptionUsingTryCatchBlock m = new _7_2_HandleExceptionUsingTryCatchBlock();
            m.method();
        } catch (Exception e) {
            System.out.println("exception handled");
        }

        System.out.println("normal flow...");
    }
    
    /*
        exception handled
        normal flow...
        
     */
}

/*
    Case 2: Declare Exception
    
            > In case we declare the exception, if exception does not occur, the code will be executed fine.
            > In case we declare the exception and the exception occurs, it will be thrown at runtime because 
                throws does not handle the exception.
       
        Let's see examples for both the scenario.
        
        A) If exception does not occur
 */
class _7_3_IfExceptionDoesNotOccur {
    void method() throws IOException {
        System.out.println("device operation performed");
    }
}

class TestThrows3 {
    public static void main(String args[]) throws IOException {//declare exception  
        _7_3_IfExceptionDoesNotOccur m = new _7_3_IfExceptionDoesNotOccur();
        m.method();

        System.out.println("normal flow...");
    }
    /*
        device operation performed
        normal flow...
     */
}

//  B) If exception occurs

class _7_4_IfExceptionOccurs {
    void method() throws IOException {
        throw new IOException("device error");
    }
}

class TestThrows4 {
    public static void main(String args[]) throws IOException { //declare exception  
        _7_4_IfExceptionOccurs m = new _7_4_IfExceptionOccurs();
        m.method();

        System.out.println("normal flow...");
    }
    /*
        Exception in thread "main" java.io.IOException: device error
     */
}

/*
=======================================================================================================================
=============================   Difference between throw and throws in Java   =========================================
=======================================================================================================================
 */

/*
    
    Difference between throw and throws in Java
    
    The throw and throws is the concept of exception handling where the throw keyword throw the exception explicitly 
    from a method or a block of code whereas the throws keyword is used in signature of the method.
    
    
+-----+----------------+--------------------------------------------------+-------------------------------------------------------+
| no. | Basis of       | throw                                            | throws                                                |
|     | Differences    |                                                  |                                                       |
+-----+----------------+--------------------------------------------------+-------------------------------------------------------+
| 1.  | Definition     | Java throw keyword is used throw                 | Java throws keyword is used in the method signature   |
|     |                | an exception explicitly in the code,             | to declare an exception which might be thrown         |
|     |                | inside the function or the block of code.        | by the function while the execution of the code.      |
+-----+----------------+--------------------------------------------------+-------------------------------------------------------+
| 2.  |                | Type of exception Using throw keyword,           | Using throws keyword, we can declare both checked     |
|     |                | we can only propagate unchecked exception i.e.,  | and unchecked exceptions.                             |
|     |                | the checked exception cannot be propagated       | However, the throws keyword can be used to propagate  |
|     |                | using throw only.                                | checked exceptions only.                              |
+-----+----------------+--------------------------------------------------+-------------------------------------------------------+
| 3.  | Syntax         | The throw keyword is followed                    | The throws keyword is followed by class names         |
|     |                | by an instance of Exception to be thrown.        | of Exceptions to be thrown.                           |
+-----+----------------+--------------------------------------------------+-------------------------------------------------------+
| 4.  | Declaration    | throw is used within the method.                 | throws is used with the method signature.             |
+-----+----------------+--------------------------------------------------+-------------------------------------------------------+
| 5.  | Internal       | We are allowed to throw only one exception at    | We can declare multiple exceptions using throws       |
|     | implementation | a time i.e. we cannot throw multiple exceptions. | keyword that can be thrown by the method.             |
|     |                |                                                  | For example, main() throws IOException, SQLException. |
+-----+----------------+--------------------------------------------------+-------------------------------------------------------+  
 
 */


//  Java throw Example
class _8_1_TestThrow {
    //defining a method  
    public static void checkNum(int num) {
        if (num < 1) {
            throw new ArithmeticException("\nNumber is negative, cannot calculate square");
        } else {
            System.out.println("Square of " + num + " is " + (num * num));
        }
    }

    //main method  
    public static void main(String[] args) {
        _8_1_TestThrow obj = new _8_1_TestThrow();
        obj.checkNum(-3);
        System.out.println("Rest of the code..");
    }
    /*
        Exception in thread "main" java.lang.ArithmeticException: 
        Number is negative, cannot calculate square...
     */
}

//  Java throws Example

class _8_2_TestThrows {
    //defining a method  
    public static int divideNum(int m, int n) throws ArithmeticException {
        int div = m / n;
        return div;
    }

    //main method  
    public static void main(String[] args) {
        _8_2_TestThrows obj = new _8_2_TestThrows();
        try {
            System.out.println(obj.divideNum(45, 0));
        } catch (ArithmeticException e) {
            System.out.println("\nNumber cannot be divided by 0");
        }

        System.out.println("Rest of the code..");
    }
    /*
        Number cannot be divided by 0
        Rest of the code..
     */
}

//  Java throw and throws Example

class _8_3_TestThrowAndThrows {
    // defining a user-defined method  
    // which throws ArithmeticException  
    static void method() throws ArithmeticException {
        System.out.println("Inside the method()");
        throw new ArithmeticException("throwing ArithmeticException");
    }

    //main method  
    public static void main(String args[]) {
        try {
            method();
        } catch (ArithmeticException e) {
            System.out.println("caught in main() method");
        }
    }
    /*
        Inside the method()
        caught in main() method
     */
}  

/*
=======================================================================================================================
===============================   Difference between final, finally and finalize    ===================================
=======================================================================================================================
 */
/*
Difference between final, finally and finalize

    The final, finally, and finalize are keywords in Java that are used in exception handling. 
    Each of these keywords has a different functionality. 
    The basic difference between final, finally and finalize is that the final is an access modifier, 
    finally is the block in Exception Handling and finalize is the method of object class.


+---------+---------------+------------------------------------------+-----------------------------------------+-----------------------------------------------+
| Sr. no. | Key           | final                                    | finally                                 | finalize                                      |
+---------+---------------+------------------------------------------+-----------------------------------------+-----------------------------------------------+
| 1.      | Definition    | final is the keyword and access modifier | finally is the block in Java Exception  | finalize is the method in Java which is used  |
|         |               | which is used to apply restrictions on a | Handling to execute the important code  | to perform clean up processing just before    |
|         |               | class, method or variable.               | whether the exception occurs or not.    | object is garbage collected.                  |
+---------+---------------+------------------------------------------+-----------------------------------------+-----------------------------------------------+
| 2.      | Applicable to | Final keyword is used with the classes,  | Finally block is always related to      | finalize() method is used with the objects.   |
|         |               | methods and variables.                   | the try and catch block in exception    |                                               |
|         |               |                                          | handling.                               |                                               |
+---------+---------------+------------------------------------------+-----------------------------------------+-----------------------------------------------+
| 3.      | Functionality | (1) Once declared, final variable        | (1) finally block runs the important    | finalize method performs the cleaning         |
|         |               | becomes constant and cannot be           | code even if exception occurs or not.   | activities with respect to the object         |
|         |               | modified.                                | (2) finally block cleans up all the     | before its destruction.                       |
|         |               | (2) final method cannot be overridden    | resources used in try block             |                                               |
|         |               | by sub class.                            |                                         |                                               |
|         |               | (3) final class cannot be inherited.     |                                         |                                               |
+---------+---------------+------------------------------------------+-----------------------------------------+-----------------------------------------------+
| 4.      | Execution     | Final method is executed only when we    | Finally block is executed as soon as    | finalize method is executed just before       |
|         |               | call it.                                 | the try-catch block is executed.        | the object is destroyed.                      |
|         |               |                                          | It's execution is not dependant on      |                                               |
|         |               |                                          | the exception.                          |                                               |
+---------+---------------+------------------------------------------+-----------------------------------------+-----------------------------------------------+
 */

/*

Java final Example

    Let's consider the following example where we declare final variable age. Once declared it cannot be modified.

    In the example, we have declared a variable final. Similarly, we can declare the methods and classes final
    using the final keyword.
    
 */
class _9_1_FinalExampleTest {
    //declaring final variable  
    final int age = 18;

    void display() {

        // reassigning value to age variable   
        // gives compile time error  
//        age = 55;     // <= age will be red underlined 
    }

    public static void main(String[] args) {

        _9_1_FinalExampleTest obj = new _9_1_FinalExampleTest();
        // gives compile time error  
        obj.display();
    }
}  

/*

Java finally Example
    
    Let's see the below example where the Java code throws an exception and the catch block handles that exception. 
    Later the finally block is executed after the try-catch block. Further, the rest of the code is also executed normally.

 */

class _9_2_FinallyExample {
    public static void main(String args[]) {
        try {
            System.out.println("Inside try block");
            // below code throws divide by zero exception  
            int data = 25 / 0;
            System.out.println(data);
        }
        // handles the Arithmetic Exception / Divide by zero exception  
        catch (ArithmeticException e) {
            System.out.println("Exception handled");
            System.out.println(e);
        }
        // executes regardless of exception occurred or not   
        finally {
            System.out.println("finally block is always executed");
        }
        System.out.println("rest of the code...");
    }
    /*
        Inside try block
        Exception handled
        java.lang.ArithmeticException: / by zero
        finally block is always executed
        rest of the code...
     */
}

//      Java finalize Example

class _9_3_FinalizeExample {
    public static void main(String[] args) {
        _9_3_FinalizeExample obj = new _9_3_FinalizeExample();
        // printing the hashcode   
        System.out.println("Hashcode is: " + obj.hashCode());
        obj = null;
        // calling the garbage collector using gc()   
        System.gc();
        System.out.println("End of the garbage collection");
    }

    // defining the finalize method   
    protected void finalize() {
        System.out.println("Called the finalize() method");
    }
    
    /*
        Hashcode is: 1555009629
        Called the finalize() method
        End of the garbage collection
     */
}    


/*
=======================================================================================================================
============================   Exception Handling with Method Overriding in Java    ===================================
=======================================================================================================================
 */

/*

Exception Handling with Method Overriding in Java
    
    There are many rules if we talk about method overriding with exception handling.

    Some of the rules are listed below:
        > If the superclass method does not declare an exception, subclass overridden method cannot declare the checked 
            exception but it can declare unchecked exception.
        
        > If the superclass method declares an exception, subclass overridden method can declare same, 
            subclass exception or no exception but cannot declare parent exception.
        

 */

/*
    If the superclass method does not declare an exception
    
        Rule 1: If the superclass method does not declare an exception, subclass overridden method cannot declare 
                the checked exception.

 */
class _10_0_ExceptionHandlingWithMethodOverriding {
    public static void main(String[] args) {
        System.out.println("ExceptionHandlingWithMethodOverriding");
    }
}

class Parent {

    // defining the method   
    void msg() {
        System.out.println("parent method");
    }
}

class _10_1_TestExceptionChild extends Parent {

    // overriding the method in child class  
    // gives compile time error  

//    @Override
//    void msg() throws IOException {               // <= compile error wit underlined IOException
//        System.out.println("TestExceptionChild");
//    }

    public static void main(String args[]) {
        Parent p = new _10_1_TestExceptionChild();
        p.msg();
    }
}  

/*
    Rule 2: If the superclass method does not declare an exception, subclass overridden method cannot declare 
            the checked exception but can declare unchecked exception.

 */

class Parent2 {
    void msg() {
        System.out.println("parent method");
    }
}

class _10_2_TestExceptionChild2 extends Parent2 {
    void msg() throws ArithmeticException {
        System.out.println("child method");
    }

    public static void main(String args[]) {
        Parent2 p = new _10_2_TestExceptionChild2();
        p.msg();
    }
    
    /*
        child method
     */
}  

/*
    
    If the superclass method declares an exception

    Rule 1: If the superclass method declares an exception, subclass overridden method can declare the same subclass 
            exception or no exception but cannot declare parent exception.

 */

class Parent3 {
    void msg() throws ArithmeticException {
        System.out.println("parent method");
    }
}

class _10_3_TestExceptionChild3 extends Parent3 {
    @Override
    void msg() {
//    void msg() throws Exception {        // <= compile error red underlined Exception
        System.out.println("child method");
    }

    public static void main(String args[]) {
        Parent3 p = new _10_3_TestExceptionChild3();

        try {
            p.msg();
        } catch (Exception e) {
        }

    }
}

//   Example in case subclass overridden method declares same exception

class Parent4 {
    void msg() throws Exception {
        System.out.println("parent method");
    }
}

class _10_4_TestExceptionChild4 extends Parent4 {
    void msg() throws Exception {
        System.out.println("child method");
    }

    public static void main(String args[]) {
        Parent4 p = new _10_4_TestExceptionChild4();

        try {
            p.msg();
        } catch (Exception e) {
        }
    }
    
    /*
        child method
     */
}


//  Example in case subclass overridden method declares subclass exception

class Parent5 {
    void msg() throws Exception {
        System.out.println("parent method");
    }
}

class _10_5_TestExceptionChild5 extends Parent5 {
    @Override
    void msg() throws ArithmeticException {
        System.out.println("child method");
    }

    public static void main(String args[]) {
        Parent5 p = new _10_5_TestExceptionChild5();

        try {
            p.msg();
        } catch (Exception e) {
        }
    }    
    
    /*
        child method
     */
}


//  Example in case subclass overridden method declares no exception

class Parent6 {
    void msg() throws Exception {
        System.out.println("parent method");
    }
}

class _10_6_TestExceptionChild6 extends Parent6 {
    void msg() {
        System.out.println("child method");
    }

    public static void main(String args[]) {
        Parent6 p = new _10_6_TestExceptionChild6();

        try {
            p.msg();
        } catch (Exception e) {
        }
    }
        
    /*
        child method
     */
}


/*
=======================================================================================================================
======================================   Reasons for Exception Occurrence    ==========================================
=======================================================================================================================
 */

/*
    Reasons for Exception Occurrence
    
    Several reasons lead to the occurrence of an exception. A few of them are as follows.
        > When we try to open a file that does not exist may lead to an exception.
        > When the user enters invalid input data, it may lead to an exception.
        > When a network connection has lost during the program execution may lead to an exception.
        > When we try to access the memory beyond the allocated range may lead to an exception.
        > The physical device problems may also lead to an exception.
    
    Types of Exception:
        > Checked Exception - An exception that is checked by the compiler at the time of compilation is called a checked exception.
        > Unchecked Exception - An exception that can not be caught by the compiler but occurrs at the time of program 
            execution is called an unchecked exception.


    How exceptions handled in Java?
    
         In java, the exception handling mechanism uses five keywords namely try, catch, finally, throw, and throws.

 */

/*
    List of checked exceptions in Java
    
        +-----+----------------------------------------------------------------------------------------------------------+
        | No. | Exception Class with Description                                                                         |
        +-----+----------------------------------------------------------------------------------------------------------+
        | 1   | ClassNotFoundException                                                                                   |
        |     |     It is thrown when the Java Virtual Machine (JVM) tries to load a particular                          |
        |     |     class and the specified class cannot be found in the classpath.                                      |
        +-----+----------------------------------------------------------------------------------------------------------+
        | 2   | CloneNotSupportedException                                                                               |
        |     |     Used to indicate that the clone method in class Object has been called to                            |
        |     |     clone an object, but that the object's class does not implement the Cloneable interface.             |
        +-----+----------------------------------------------------------------------------------------------------------+
        | 3   | IllegalAccessException                                                                                   |
        |     |     It is thrown when one attempts to access a method or member that visibility                          |
        |     |     qualifiers do not allow.                                                                             |
        +-----+----------------------------------------------------------------------------------------------------------+
        | 4   | InstantiationException                                                                                   |
        |     |     It is thrown when an application tries to create an instance of a class using the                    |
        |     |     newInstance method in class Class , but the specified class object cannot be instantiated            |
        |     |     because it is an interface or is an abstract class.                                                  |
        +-----+----------------------------------------------------------------------------------------------------------+
        | 5   | InterruptedException                                                                                     |
        |     |     It is thrown when a thread that is sleeping, waiting, or is occupied is interrupted.                 |
        +-----+----------------------------------------------------------------------------------------------------------+
        | 6   | NoSuchFieldException                                                                                     |
        |     |     It indicates that the class doesn't have a field of a specified name.                                |
        +-----+----------------------------------------------------------------------------------------------------------+
        | 7   | NoSuchMethodException                                                                                    |
        |     |     It is thrown when some JAR file has a different version at runtime that it had at compile time,      |
        |     |     a NoSuchMethodException occurs during reflection when we try to access a method that does not exist. |
        +-----+----------------------------------------------------------------------------------------------------------+
        
        

    List of unchecked exceptions in Java
    
            +-----+-------------------------------------------------------------------------------------------------+
            | No. | Exception Class with Description                                                                |
            +-----+-------------------------------------------------------------------------------------------------+
            | 1   | ArithmeticException                                                                             |
            |     |     It handles the arithmetic exceptions like dividion by zero                                  |
            +-----+-------------------------------------------------------------------------------------------------+
            | 2   | ArrayIndexOutOfBoundsException                                                                  |
            |     |    It handles the situations like an array has been accessed with an illegal index.             |
            |     |    The index is either negative or greater than or equal to the size of the array.              |
            +-----+-------------------------------------------------------------------------------------------------+
            | 3   | ArrayStoreException                                                                             |
            |     |    It handles the situations like when an attempt has been made to store the wrong              |
            |     |    type of object into an array of objects                                                      |
            +-----+-------------------------------------------------------------------------------------------------+
            | 4   | AssertionError                                                                                  |
            |     |    It is used to indicate that an assertion has failed                                          |
            +-----+-------------------------------------------------------------------------------------------------+
            | 5   | ClassCastException                                                                              |
            |     |    It handles the situation when we try to improperly cast a class from one type to another.    |
            +-----+-------------------------------------------------------------------------------------------------+
            | 6   | IllegalArgumentException                                                                        |
            |     |    This exception is thrown in order to indicate that a method has been passed an illegal       |
            |     |    or inappropriate argument.                                                                   |
            +-----+-------------------------------------------------------------------------------------------------+
            | 7   | IllegalMonitorStateException                                                                    |
            |     |    This indicates that the calling thread has attempted to wait on an object's monitor,         |
            |     |    or has attempted to notify other threads that wait on an object's monitor, without           |
            |     |    owning the specified monitor.                                                                |
            +-----+-------------------------------------------------------------------------------------------------+
            | 8   | IllegalStateException                                                                           |
            |     |    It signals that a method has been invoked at an illegal or inappropriate time.               |
            +-----+-------------------------------------------------------------------------------------------------+
            | 9   | IllegalThreadStateException                                                                     |
            |     |    It is thrown by the Java runtime environment, when the programmer is trying                  |
            |     |    to modify the state of the thread when it is illegal.                                        |
            +-----+-------------------------------------------------------------------------------------------------+
            | 10  | IndexOutOfBoundsException                                                                       |
            |     |    It is thrown when attempting to access an invalid index within a collection,                 |
            |     |    such as an array , vector , string , and so forth.                                           |
            +-----+-------------------------------------------------------------------------------------------------+
            | 11  | NegativeArraySizeException                                                                      |
            |     |    It is thrown if an applet tries to create an array with negative size.                       |
            +-----+-------------------------------------------------------------------------------------------------+
            | 12  | NullPointerException                                                                            |
            |     |    it is thrown when program attempts to use an object reference that has the null value.       |
            +-----+-------------------------------------------------------------------------------------------------+
            | 13  | NumberFormatException                                                                           |
            |     |    It is thrown when we try to convert a string into a numeric value such as float or integer,  |
            |     |    but the format of the input string is not appropriate or illegal.                            |
            +-----+-------------------------------------------------------------------------------------------------+
            | 14  | SecurityException                                                                               |
            |     |    It is thrown by the Java Card Virtual Machine to indicate a security violation.              |
            +-----+-------------------------------------------------------------------------------------------------+
            | 15  | StringIndexOutOfBounds                                                                          |
            |     |    It is thrown by the methods of the String class, in order to indicate that                   |
            |     |    an index is either negative, or greater than the size of the string itself.                  |
            +-----+-------------------------------------------------------------------------------------------------+
            | 16  | UnsupportedOperationException                                                                   |
            |     |    It is thrown to indicate that the requested operation is not supported.                      |
            +-----+-------------------------------------------------------------------------------------------------+        
 */