package com.company.sorting_algorithm.quick_sort;

import java.util.Arrays;
/*

Q #1) How does a Quicksort work?

Answer: Quicksort uses a divide and conquers strategy. Quicksort first partitions
an array around a pivot element selected and generates sub-arrays that are sorted recursively.

Q #2) What is the time complexity of Quicksort?

Answer: The time complexity of quicksort on an average is O (nlogn).
In the worst case, it is O (n^2) the same as the selection sort.

Q #3) Where is Quicksort used?

Answer: Quicksort is mostly used in recursive applications. Quicksort is the part
of C-library. Also, almost the programming languages that use built-in sorting implement quicksort.

Q #4) What is the advantage of Quicksort?

Answer:

Quicksort is an efficient algorithm and can easily sort even a huge list of elements.
It is in-place sort and hence does not need extra space or memory.
It is widely used and provides an efficient way to sort data sets of any length.
Q #5) Why is Quicksort better than the merge sort?

Answer: The main reason for which the quicksort is better than the merge sort is
that quicksort is in-place sorting method and does not require additional memory space.
Merge sort requires additional memory for intermediate sorting.
*/

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