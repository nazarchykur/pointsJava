package com.company.sorting_algorithm.selection_sort;

import java.util.Arrays;

public class SelectionSort_3 {
    public static void main(String[] args) {
        int[] array = {55, 8, 21, 6, 3, 9, 5, 8, 2, 2, 30, 1};
        System.out.println("array = " + Arrays.toString(array));

        selectionSort(array);
        System.out.println("array = " + Arrays.toString(array));
    }

    private static void selectionSort(int[] array) {
        for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largest = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (array[i] > array[largest]) {
                    largest = i;
                }
            }

            swap(array, largest, lastUnsortedIndex);
        }
    }

    private static void swap(int[] array, int largest, int lastUnsortedIndex) {
        if (array[largest] == array[lastUnsortedIndex]) {
            return;
        }
        int temp = array[largest];
        array[largest] = array[lastUnsortedIndex];
        array[lastUnsortedIndex] = temp;

    }
}
