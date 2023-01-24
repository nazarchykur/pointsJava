package com.company.exception_handling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*

    Why, When and How to Implement Custom Exceptions in Java
        THORBEN JANSSENNOVEMBER 9, 2017
    
    https://stackify.com/java-custom-exceptions/

 */
/*
Checked And Unchecked Exceptions in Java

        Java supports checked and unchecked exceptions. You can use them in similar ways, and there are quite 
        a few discussions about when to use which kind of exception. But that’s beyond the scope of this post. 
        For now, let’s just follow the approach explained in Oracle’s Java Tutorial.

        You should use checked exceptions for all exceptional events that you can anticipate and that a well-written 
        application should be able to handle. A checked exception extends the Exception class. 
        A method that throws a checked exception or that calls a method that specifies a checked exception 
        needs to either specify or handle it.

        Unchecked exceptions extend the RuntimeException. You should use them for internal errors that you can’t 
        anticipate and that, most often, the application can’t recover from. Methods can but don’t need to handle or 
        specify an unchecked exception. Typical examples that throw unchecked exceptions are:
           > the missing initialization of a variable which results in a NullPointerException or
           > the improper use of an API that causes an IllegalArgumentException
*/

/*

    You should provide detailed information about the situation that caused the exception, and you should not 
    remove anything that might be useful to the caller.
    
    You often can achieve that by using standard exceptions with good messages. 
    The Java Exception class describes the kind of event, and the message provides detailed information about it. 
    You can take this concept one step further by using a custom exception.
    
    Custom exceptions provide you the flexibility to add attributes and methods that are not part of a standard 
    Java exception. These can store additional information, like an application-specific error code, or provide 
    utility methods that can be used to handle or present the exception to a user.



    4 best practices for custom exceptions
    
        There are 4 general best practices that you should follow when you decide to implement a custom exception class. 
        These recommendations make your code and API easier to understand. 
        They also reduce the required amount of documentation. 
        That quickly pays off if multiple developers work on the same application or library, 
        new team members join your project, or a third-party software vendor decides to use your APIs.

*/

class _1_AlwaysProvideABenefit{}
/*

1. Always provide a benefit

    The additional attributes or methods showed the intention of a custom exception. 
    It provides information or functionality that is not part of Java’s standard exceptions.
    
    That’s the essence of the first and most important recommendation. Otherwise, your exception doesn’t provide 
    any benefit compared to the vast number of exceptions that are already provided by the JDK.
    
    If you can’t provide any benefits, you should better use one of the standard exceptions, 
    like UnsupportedOperationException or IllegalArgumentException. All Java developers already know these exceptions. 
    That makes your code and API easier to understand.

*/

class _2_FollowTheNamingConvention{}
/*
2. Follow the naming convention

    When you take a look at the exception classes provided by the JDK, you quickly recognize that all of their names 
    end with “Exception”. This general naming convention is used throughout the Java ecosystem. 
    And your custom exception should follow it as well.

 */

class _3_ProvideJavadocCommentsForYourExceptionClass{}
/*
3. Provide Javadoc comments for your exception class

    We shouldn’t need to talk about this best practice, but I have seen way too many custom exceptions without any Javadoc.
    
    It’s a general best practice to document all classes, fields, constructors, and methods of your API. 
    If you ever had to use an undocumented API, you know exactly why. Undocumented APIs are very difficult to use.
    
    Exception classes might not be the most obvious part of your API, but they are still part of it. 
    As soon as one of your client-facing methods throws an exception, the exception class becomes part of the API. 
    That implies that it requires documentation and a good Javadoc.
    
    The Javadoc should describe the general meaning of the exception and the situations in which it might occur. 
    The goal is to help other developers to understand your API and to avoid common error scenarios.

 */



/**
 * The MyCustomBusinessException wraps all checked standard Java exception and enriches them with a custom error code.
 * You can use this code to retrieve localized error messages and to link to our online documentation.
 *
 * @author TJanssen
 */
class MyCustomBusinessException extends Exception {
    // code
}


/*
4. Provide a constructor that sets the cause

    Quite often, your code catches a standard exception before you throw your custom exception. 
    You should not hide this fact. The caught exception usually contains essential information that you will need 
    to analyze a production incident.
    
    In the following example, the NumberFormatException provides detailed information about the error. 
    You will lose this information if you don’t set it as the cause of the MyCustomBusinessException.

 */

class _4_ProvideAConstructorThatSetsTheCause {
        

    public void wrapException(String input) throws MyCustom2BusinessException {
        try {
            // do something
        } catch (NumberFormatException e) {
            throw new MyCustom2BusinessException("A message that describes the error.", e, ErrorCode.INVALID_PORT_CONFIGURATION);
        }
    }
}

/*

    Exception and RuntimeException provide constructor methods that accept a Throwable which describes the cause 
    of the exception. And your exception should do the same. You should implement at least one constructor that gets 
    the causing Throwable as a parameter and sets it on the superclass.

 */
class MyCustom2BusinessException extends Exception {

    private final ErrorCode code;

    public MyCustom2BusinessException(String message, Throwable cause, ErrorCode code) {
        super(message, cause);
        this.code = code;
    }

	// ...
}


/*

    Implementing a Custom Exception
    
    
    When you implement a checked exception, you need to extend the class Exception. 
    That’s the only thing you need to do to create a custom exception class. 
    But as I explained earlier, you should also provide a constructor method that sets the causing exception 
    and provide a benefit compared to the available standard exceptions.

    The following example does all of that. As you can see, I added a Javadoc comment that describes the exception. 
    I also implemented a constructor method that sets the causing exception on the superclass. 
    And to provide a benefit compared to the standard exceptions, MyBusinessException uses a custom enumeration 
    to store an error code that identifies the problem. Clients can use the error code to show localized error messages 
    or tell the user to include this code in a support ticket.

 */


/**
 * The My3BusinessException wraps all checked standard Java exception and enriches them with a custom error code.
 * You can use this code to retrieve localized error messages and to link to our online documentation.
 *
 * @author TJanssen
 */ 
class My3BusinessException extends Exception {

    private static final long serialVersionUID = 7718828512143293558L;

    private final ErrorCode code;

    public My3BusinessException(ErrorCode code) {
        super();
        this.code = code;
    }

    public My3BusinessException(String message, Throwable cause, ErrorCode code) {
        super(message, cause);
        this.code = code;
    }

    public My3BusinessException(String message, ErrorCode code) {
        super(message);
        this.code = code;
    }

    public My3BusinessException(Throwable cause, ErrorCode code) {
        super(cause);
        this.code = code;
    }

    public ErrorCode getCode() {
        return this.code;
    }
}

/*

    That’s all you need to do to implement a custom checked exception. 
    You can now throw the MyBusinessException in your code, specify it as part of your method signature and 
    handle it in a catch clause.
    
 */

class ImplementingCustomException{
    Logger log = LoggerFactory.getLogger(ImplementingCustomException.class);
    public void handleExceptionInOneBlock() {
        try {
            wrapException(new String("99999999"));
        } catch (My3BusinessException e) {
            // handle exception
            log.error(String.valueOf(e));
        }
    }

    private void wrapException(String input) throws My3BusinessException {
        try {
            // do something
        } catch (NumberFormatException e) {
            throw new My3BusinessException("A message that describes the error.", e, ErrorCode.INVALID_PORT_CONFIGURATION);
        }
    }
}


/*
    
    Implementing an Unchecked Exception
    
    The implementation of a custom unchecked exception is almost identical to a checked exception. 
    You should follow the same recommendations as I explained at the beginning of this post. 
    The only difference is that an unchecked exception has to extend RuntimeException instead of Exception.
    
 */

/**
 * The MyUncheckedBusinessException wraps all unchecked standard Java exception and enriches them with a custom error code.
 * You can use this code to retrieve localized error messages and to link to our online documentation.
 *
 * @author TJanssen
 */
class MyUncheckedBusinessException extends RuntimeException {

    private static final long serialVersionUID = -8460356990632230194L;

    private final ErrorCode code;

    public MyUncheckedBusinessException(ErrorCode code) {
        super();
        this.code = code;
    }

    public MyUncheckedBusinessException(String message, Throwable cause, ErrorCode code) {
        super(message, cause);
        this.code = code;
    }

    public MyUncheckedBusinessException(String message, ErrorCode code) {
        super(message);
        this.code = code;
    }

    public MyUncheckedBusinessException(Throwable cause, ErrorCode code) {
        super(cause);
        this.code = code;
    }

    public ErrorCode getCode() {
        return this.code;
    }
}

/*
    
    You can use the MyUncheckedBusinessException in the same way as any other unchecked exception. 
    You can throw it in your code and catch it in a catch clause. 
    And you can but don’t need to specify if your method throws it.
    
 */

class ImplementingUncheckedException{
    private void wrapException(String input) {
        try {
            // do something
        } catch (NumberFormatException e) {
            throw new MyUncheckedBusinessException("A message that describes the error.", e, ErrorCode.INVALID_PORT_CONFIGURATION);
        }
    }
}

/*

Summary

    As described in this post, the implementation of a custom exception is easy. You just need to extend Exception 
    for a custom checked exception, or RuntimeException if it’s a custom unchecked exception.
    
    In addition to that, you should follow a few best practices. 
    They make your code easier to read and your API easier to use. 
    Here are the 4 most important best practices for custom exceptions in Java:
    
        > You should only implement a custom exception if it provides a fibenet compared to Java’s standard exceptions.
        > The class name of your exception should end with Exception.
        > If an API method specifies an exception, the exception class becomes part of the API, and you need to document it.
        > You should provide a constructor which sets the cause of the exception.
    

 */



enum ErrorCode {
    INVALID_PORT_CONFIGURATION
}
public class CustomExceptions4BestPractices {
}
