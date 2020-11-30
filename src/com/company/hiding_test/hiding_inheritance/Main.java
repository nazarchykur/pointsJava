package com.company.hiding_test.hiding_inheritance;

public class Main {
    public static void main(String[] args) {
        ParentVariable parentVariable = new ParentVariable();
        ParentVariable childVariable_1 = new ChildVariable();
        ChildVariable childVariable_2 = new ChildVariable();

        // при створенні обєкту
        // для МЕТОДІВ при наслідуванні завжди посилається на конструктор
        // тобто відбувається run time (dynamic) binding
        // тобто polymorphism
        parentVariable.printInstanceVariable();   // print parent method
        childVariable_1.printInstanceVariable();   // print child method
        childVariable_2.printInstanceVariable();   // print  child method

        System.out.println();
        System.out.println("************************************");
        // для змінних відбувається звязування до типу змінної
        // тобто compile time binding

        System.out.println(parentVariable.instanceVariable);  // print parent variable
        System.out.println(childVariable_1.instanceVariable);  // print parent variable
        System.out.println(childVariable_2.instanceVariable);  // print child variable


// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// In most cases, we should avoid creating variables
// with the same name both in parent and child classes.
// Instead, we should use a proper access modifier
// like private and provide getter/setter methods for that purpose.


    }
}
