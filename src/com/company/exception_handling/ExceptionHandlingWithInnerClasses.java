package com.company.exception_handling;


//  https://howtodoinjava.com/java/exception-handling/best-practices-for-for-exception-handling/

public class ExceptionHandlingWithInnerClasses {
}

class _1_TraditionalExceptionHandling {
}
/*
1.1. Traditional exception handling

    Our new approach uses static inner classes for every new exceptional scenario.
    
    Traditionally, we create a DBException class by extending Exception class. 
    Now, every time we are caught in a situation where there is a need to throw a database related exception, 
    we usually create an instance of DBException, put some information in form of the message and throw it.
    
    Now, let’s consider there are following situations we have identified in which we need to throw DBException:
    
        > SQL execution error
        > No data exist where we expect at least one row
        > Multiple rows exist where we expect only single row
        > Invalid parameters error
        > and many more such cases
        
    The problem with above approach is that in catch block or in application code where these exceptions shall be handled, 
    DBException does not provide enough information to handle each abode listed use cases, uniquely.

 */


class _2_NewExceptionHandlingWithInnerClasses {
} 

/*

1.2. New exception handling with inner classes
    
    Let’s solve the above problem with inner classes where we will create one class per use-case, 
    and then group them inside DBException class.
        
    Lets start with BaseException class which is created as abstract and will be super class of all our exception classes.

 */

// Make this class abstract so that developers are forced to create suitable exception types only
abstract class BaseException extends Exception {
    //Each exception message will be held here
    private String message;

    public BaseException(String msg) {
        this.message = msg;
    }

    //Message can be retrieved using this accessor method
    public String getMessage() {
        return message;
    }
}

class DBExeption {
    //SQL execution error
    public static class BadExecution extends BaseException {
        private static final long serialVersionUID = 3555714415375055302L;

        public BadExecution(String msg) {
            super(msg);
        }
    }

    //No data exist where we expect at least one row
    public static class NoData extends BaseException {
        private static final long serialVersionUID = 8777415230393628334L;

        public NoData(String msg) {
            super(msg);
        }
    }

    //Multiple rows exist where we expect only single row
    public static class MoreData extends BaseException {
        private static final long serialVersionUID = -3987707665150073980L;

        public MoreData(String msg) {
            super(msg);
        }
    }

    //Invalid parameters error
    public static class InvalidParam extends BaseException {
        private static final long serialVersionUID = 4235225697094262603L;

        public InvalidParam(String msg) {
            super(msg);
        }
    }
}

/*
    Here, we created an inner class for each possible error scenario identified in starting. 
    There can be many more extras. It depends on you only to identify and add more classes.
 */

/*

1.3. How to use custom exceptions

    Now to understand it’s usefulness, let’s create an exception and throw it. Then we will see the error message in logs.

 */

class TestExceptions {
    public static void main(String[] args) {
        try {
            throw new DBExeption.NoData("No row found for id : x");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*
        Program output:
            com.company.exception_handling.DBExeption$NoData: No row found for id : x
	            at com.company.exception_handling.TestExceptions.main(ExceptionHandlingWithInnerClasses.java:114)
	
	
        As you can see the log message in exception stack trace, it has become more informative. 
        It clearly tells what is the error. 
        In application code as well, you can check the instance of custom exception and handle accordingly.
        	
     */
}

/*

Advantages of using inner classes as custom exceptions:

    1. Foremost advantage is that if you developer has written some doubtful message text, 
        then also you can clearly observe that what was actually wrong.
        
    2. You can use instance-of comparison in different situation where you handle different exceptional scenarios.
    
    3. You don’t need to send single exception for a large set of exceptional conditions.
    
    4. Its easy to write unit test cases for negative cases where you know the exact exception class, you should expect.
    
    5. Logging is more meaningful and informative.

 */