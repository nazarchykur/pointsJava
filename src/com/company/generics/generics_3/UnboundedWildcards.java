package com.company.generics.generics_3;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class UnboundedWildcards {
    public static void main(String[] args) {
        // ? Wildcards
        // Unbounded Wildcards
        List<Object> list1 = Arrays.asList("5", 8, "some string", new Date());
        List<Integer> list2 = Arrays.asList(1, 2);
        List<String> list3 = Arrays.asList("1", "2");
        
        print(list1);
        //java.lang.String - 5
        //java.lang.Integer - 8
        //java.lang.String - some string
        //java.util.Date - Sun Jul 31 17:11:53 EEST 2022
        System.out.println();
        
        print(list2);
        //java.lang.Integer - 1
        //java.lang.Integer - 2
        System.out.println();
        
        print(list3);
        //java.lang.String - 1
        //java.lang.String - 2
    }

    static void print(List<?> list) {
        list.forEach(e -> System.out.println(e.getClass().getName() + " - " + e));
    }
}
