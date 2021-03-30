package com.company.sorting_algorithm.bubble_sort;

import java.util.Arrays;

public class BubbleSort_4 {
    public static void main(String[] args) {
        int[] array = {55, 8, 21, 6, 3, 9, 5, 8, 2, 2, 30, 1};
        System.out.println("array = " + Arrays.toString(array));

        bubbleSort(array);
        System.out.println("array = " + Arrays.toString(array));
    }

    private static void bubbleSort(int[] array) {
        for (int i = array.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j+1])
                    swap(array, j, j+1);
                
            }
            
        }
    }

    private static void swap(int[] array, int j, int i) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
