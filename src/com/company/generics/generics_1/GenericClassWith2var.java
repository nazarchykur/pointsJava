package com.company.generics.generics_1;

public class GenericClassWith2var<T1, T2> {
    private T1 field1;
    private T2 field2;

    public GenericClassWith2var(T1 field1, T2 field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public void print() {
        System.out.println("field1=" + field1 + ", type of " + field1.getClass().getName());
        System.out.println("field2=" + field1 + ", type of " + field2.getClass().getName());
    }

    public void sum() {
//        System.out.println(field1 + field2); // operation not allowed here
    }
}
