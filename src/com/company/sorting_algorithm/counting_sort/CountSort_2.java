package com.company.sorting_algorithm.counting_sort;

import java.util.Arrays;

public class CountSort_2 {
    public static void main(String[] args) {
        int[] array = {5, 8, 2, 6, 3, 9, 5, 8, 2, 2, 3, 10, 1};
        System.out.println("array = " + Arrays.toString(array));

        countingSort(array);
//        System.out.println("array = " + Arrays.toString(array));
    }

    private static void countingSort(int[] array) {
        int max = maxValue(array);
        int[] numCounts = new int[max + 1];
        for (int num: array) {
            numCounts[num]++;
        }
        int[] sorted = new int[array.length];
        int index = 0;
        for (int i = 0; i < numCounts.length; i++) {
            for (int j = 0; j < numCounts[i]; j++) {
                sorted[index] = i;
                index++;
            }
        }
        System.out.println(Arrays.toString(sorted));
    }

    private static int maxValue(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
