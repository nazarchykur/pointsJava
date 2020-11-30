package com.company.hiding_test.hiding_variable_local;

public class HideVariable {
//instance variables – defined inside of a class and belong to the instance of the object
//local variables – declared in a piece of code such as methods, constructors, in any block of code with curly braces

// Here we have the message variable declared in 4 different places.
// The local variables declared inside of the constructor and the two methods are shadowing the instance variable.

    private String message = "this is instance variable"; // змінна класу = поле класу, яка належить обєкту

    public HideVariable() {
        String message = "constructor local variable"; // локальна змінна в методі
        System.out.println(message); // звертаємося до цієї локальної змінної
    }

    public void printLocalVariable() {
        String message = "method local variable"; // локальна змінна в методі
        System.out.println(message); // звертаємося до цієї локальної змінної
    }

    public void printInstanceVariable() {
        String message = "method local variable"; // локальна змінна в методі
        System.out.println(this.message); // THIS вказує на поле класу, тобто використовується вказник на змінну обєкта
    }

    public static void main(String[] args) {
        HideVariable variable = new HideVariable(); // print constructor local variable
        variable.printInstanceVariable(); // print this is instance variable ,
        variable.printLocalVariable(); // print method local variable
    }

}
