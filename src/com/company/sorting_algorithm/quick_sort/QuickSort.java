package com.company.sorting_algorithm.quick_sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {55, 8, 21, 6, 3, 9, 5, 8, 2, 2, 30, 1};
        System.out.println("array = " + Arrays.toString(array));

        quickSort(array, 0, array.length);
        System.out.println("array = " + Arrays.toString(array));
    }

    private static void quickSort(int[] array, int start, int end) {
        if (end - start < 2) {
            return;
        }
        int pivotIndex = partition(array, start, end);
        quickSort(array, start, pivotIndex);
        quickSort(array, pivotIndex + 1, end);
    }

    private static int partition(int[] array, int start, int end) {
        // This is using th first element as the pivot
        int pivot = array[start];
        int i = start;
        int j = end;

        while (i < j) {

            // NOTE: empty loop body
            while (i < j && array[--j] >= pivot) ;
            if (i < j) {
                array[i] = array[j];
            }

            // NOTE: empty loop body
            while (i < j && array[++i] <= pivot);
            if (i < j) {
                array[j] = array[i];
            }

        }
        array[j] = pivot;
        return j;
    }
}
