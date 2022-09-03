package com.company.generics.generics_3;

import java.util.Arrays;
import java.util.List;

public class LowerBoundedWildcards {
    public static void main(String[] args) {
        // ? Wildcards
        // Lower Bounded Wildcards
        List<Integer> list2 = Arrays.asList(1, 2);
        List<Double> list4 = Arrays.asList(1.5, 2.9);

        List<Number> list3 = Arrays.asList(1, 2.3, 5.0, 9, 8);
        
        printNumbers(list2);
        //java.lang.Integer - 1
        //java.lang.Integer - 2
        
        System.out.println();
//        printNumbers(list4); // compile error => because we set List<? super Integer> 
        
        System.out.println();
        printNumbers(list3);
        //java.lang.Integer - 1
        //java.lang.Double - 2.3
        //java.lang.Double - 5.0
        //java.lang.Integer - 9
        //java.lang.Integer - 8
    }

    static void printNumbers(List<? super Integer> list) {
        list.forEach(e -> System.out.println(e.getClass().getName() + " - " + e));
    }
}
