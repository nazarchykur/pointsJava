package com.company.comparison;

import java.util.*;

public class Comparison {
    public static void main(String[] args) {
        String b = "b";
        String d = "d";
        String c = "c";
        String a = "a";

        List<String> strings = new ArrayList<>(Arrays.asList(a, b, c, d));
        System.out.println("before sorting = " + strings);

        // with lambda
        strings.sort((s1, s2) -> s1.compareTo(s2));
        System.out.println("after sorting with lambda = " + strings);

        // method reference
        strings.sort(String::compareTo);
        System.out.println("after sorting method reference 1 = " + strings);

        // кращий варіант String::compareTo , даний компаратор всеодно спуститься до порівняння елеементів
        // так як в нас String , то ми дійдемо до його перезаписаного методу compareTo
        strings.sort(Comparator.naturalOrder());
        System.out.println("after sorting method reference 2 = " + strings);
        strings.sort(Collections.reverseOrder());
        System.out.println("after sorting = " + strings);
    }
}


