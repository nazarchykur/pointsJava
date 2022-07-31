package com.company.generics.generics_3.generics_and_classes;

public class GenericsAndClasses {
    public static void main(String[] args) {
        Box<Phone> box = new Box<>();
        box.set(new Phone("Nokia"));
        System.out.println(box.get()); // Phone{brand='Nokia'}

        Box<Letter> box2 = new Box<>();
        box2.set(new Letter("some code"));
        System.out.println(box2.get()); // Letter{sender='some code'}
    }
}
