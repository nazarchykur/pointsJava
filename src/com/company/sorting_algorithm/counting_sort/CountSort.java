package com.company.sorting_algorithm.counting_sort;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] array = {5, 8, 2, 6, 3, 9, 5, 8, 2, 2, 3, 10, 1};
        System.out.println("array = " + Arrays.toString(array));

        countingSort(array, 1, 10);
        System.out.println("array = " + Arrays.toString(array));
    }

    private static void countingSort(int[] array, int min, int max) {
        int[] countArray = new int[(max - min) + 1];
        
        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min]++;  
        }

        int j = 0;

        for (int i = min; i <=max ; i++) {
            while (countArray[i - min] > 0) {
                array[j++] = i;
                countArray[i - min]--;
            }
        }
    }
}
