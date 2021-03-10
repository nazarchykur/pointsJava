package com.company.sorting_algorithm.bubble_sort;


import java.util.Arrays;

public class BubbleSort_2 {
    public static void main(String[] args) {
        int[] array = {55, 8, 21, 6, 3, 9, 5, 8, 2, 2, 30, 1};
        System.out.println("array = " + Arrays.toString(array));

        bubbleSort(array);
        System.out.println("array = " + Arrays.toString(array));
    }

    static void bubbleSort(int[] array) {
        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i+1]) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }
}
