package com.company.generics.generics_3;

public class BoundedTypeParameter {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(countGreaterThan(numbers, 7)); // 2

        Double[] numbers2 = {1.0, 2.0, 3.8, 5.55, 6.1, 7.8, 9.4};
        System.out.println(countGreaterThan(numbers2, 5.55)); // 3
    }

    interface A {
    }

    interface B {
    }

    static <T extends Comparable<T>> int countGreaterThan(T[] numbers, T numberToCompare) {
        int count = 0;
        for (T n : numbers) {
            if (n.compareTo(numberToCompare) > 0) {
                count++;
            }
        }
        return count;
    }
}
