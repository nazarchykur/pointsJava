package com.company.sorting_algorithm.quick_sort;

import java.util.Arrays;

public class QuickSort_2 {
    public static void main(String[] args) {
        int[] array = {55, 8, 21, 6, 3, 9, 5, 8, 2, 2, 30, 1};
        System.out.println("array = " + Arrays.toString(array));

        quickSort(array, 0, array.length-1);
        System.out.println("array = " + Arrays.toString(array));
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            // pi is partitioning index, arr[p] is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */
    static int partition(int[] arr, int low, int high) {
        // pivot
        int pivot = arr[high];

        // Index of smaller element and indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller than the pivot
            if (arr[j] < pivot) {

                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    // A utility function to swap two elements
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}