package com.company.generics.generics_3;

import java.util.Arrays;
import java.util.List;

public class UpperBoundedWildcards {
    public static void main(String[] args) {
        // ? Wildcards
        // Upper Bounded Wildcards
        List<Double> list1 = Arrays.asList(7.9, 6.6);
        List<Integer> list2 = Arrays.asList(10, 20);
        List<Number> list3 = Arrays.asList(4, 4.44, 7, 8.888);
        
        printNumbers(list1);
        //java.lang.Double - 7.9
        //java.lang.Double - 6.6
        System.out.println();
        
        printNumbers(list2);
        //java.lang.Integer - 10
        //java.lang.Integer - 20
        System.out.println();
        
        printNumbers(list3);
        //java.lang.Integer - 4
        //java.lang.Double - 4.44
        //java.lang.Integer - 7
        //java.lang.Double - 8.888
    }

    static void printNumbers(List<? extends Number> list) {
        list.forEach(e -> System.out.println(e.getClass().getName() + " - " + e));
    }
}
