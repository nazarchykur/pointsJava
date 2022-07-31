package com.company.generics.generics_3;

public class GenericAndMethods {
    public static void main(String[] args) {
        String name = "Name 1";
        String[] names = {name, "Name 2"};
        Character[] letters = {'A', 'B', 'C'};
        Integer[] numbers = {1, 2, 3, 4, 5};

        print(names);
        // java.lang.String - Name 1
        // java.lang.String - Name 2
        
        System.out.println();
        print(letters);
        // java.lang.Character - A
        // java.lang.Character - B
        // java.lang.Character - C
        
        System.out.println();
        print(numbers);
        // java.lang.Integer - 1
        // java.lang.Integer - 2
        // java.lang.Integer - 3
        // java.lang.Integer - 4
        // java.lang.Integer - 5
    }

    private static <T> void print(T[] array) {
        for (T e : array) {
            System.out.println(e.getClass().getName() + " - " + e);
        }
    }
}
