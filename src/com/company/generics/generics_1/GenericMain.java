package com.company.generics.generics_1;

public class GenericMain {
    public static void main(String[] args) {
        GenericClass<String> obj1 = new GenericClass<>("obj 1 with string field");
        obj1.print();   // field=obj 1 with string field, type of java.lang.String

        GenericClass<Integer> obj2 = new GenericClass<>(2);
        obj2.print();   // field=2, type of java.lang.Integer

        GenericClass<Double> obj3 = new GenericClass<>(3.33);
        obj3.print();   // field=3.33, type of java.lang.Double

        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println("----------     GenericClassWith2var      -----------------");
        System.out.println("------------------------------------------------------------");

        GenericClassWith2var<Integer, Integer> obj4 = new GenericClassWith2var(1, 2);
        obj4.print();   
        // field1=1, type of java.lang.Integer
        // field2=1, type of java.lang.Integer

        System.out.println();
        GenericClassWith2var<Double, String> obj5 = new GenericClassWith2var(8.25, "plus");
        obj5.print();   
        // field1=8.25, type of java.lang.Double
        // field2=8.25, type of java.lang.String

        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println("---------     GenericClass With  Extends      --------------");
        System.out.println("------------------------------------------------------------");
        
        GenericClassWithExtends<Integer> obj6 = new GenericClassWithExtends<>(6);
        System.out.println(obj6.square());  // 36.0

    }
}
