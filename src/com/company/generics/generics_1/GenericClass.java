package com.company.generics.generics_1;

public class GenericClass<T> {

    private T field;

    public GenericClass(T field) {
        this.field = field;
    }

    public void print() {
        System.out.println("field=" + field + ", type of " + field.getClass().getName());
    }
}
