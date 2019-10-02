package com.company.hiding_test.hide_static;

public class HideStatic {
    // Method hiding may happen in any hierarchy structure in java.
    // When a child class defines a static method with the same signature
    // as a static method in the parent class, then the child's method hides the one in the parent class.


    // Hiding doesn't work like overriding, because static methods are not polymorphic.
    // Overriding occurs only with instance methods. It supports late binding,
    // so which method will be called is determined at runtime.
    //
    //On the other hand, method hiding works with static ones. Therefore it's determined at compile time.

    public static void main(String[] args) {

        // НЕ потрібно створювати обєкти, щоб звертатися до статичних методів та змінних
//        ParentClass parentClass_1 = new ParentClass();
//        ParentClass parentClass_2 = new ChildClass();
//        ChildClass childClass = new ChildClass();

        ParentClass.printMessage();  // print Parent static method
        ChildClass.printMessage();   // print Child static method

        System.out.println();
        System.out.println("***********************************");
        System.out.println(ParentClass.staticVariable); // print Parent static var
        System.out.println(ChildClass.staticVariable); // print Child static var

        ParentClass parentClass_1 = new ParentClass();
        ParentClass parentClass_2 = new ChildClass();
        ChildClass childClass = new ChildClass();
        parentClass_1.printMessage();
        parentClass_2.printMessage();
        childClass.printMessage();



    }


}
