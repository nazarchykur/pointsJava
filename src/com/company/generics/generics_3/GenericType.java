package com.company.generics.generics_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericType {
    public static void main(String[] args) {
        //      List<E>
        List<String> names = new ArrayList<>();
        names.add("Name 1");

        List<Integer> numbers = new ArrayList<>();

        //      Map<K, V>
        Map<String, String> map = new HashMap<>();

        Map<Integer, Double> map2 = new HashMap<>();
        
       /*
            Naming Convention
            E – Element (used extensively by the Java Collections Framework, for example ArrayList, Set etc.)
            K – Key (Used in Map)
            V – Value (Used in Map)
            N – Number
            T – Type
         */
    }
}
