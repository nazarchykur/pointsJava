package com.company.hiding_test.hide_static;

public class ChildClass extends ParentClass{

    static String staticVariable= "Child static var";

    public static void printMessage() {
        System.out.println("Child static method");
    }

}
