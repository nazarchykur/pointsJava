package com.company.sorting_algorithm.shell_sorting;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] array = {55, 8, 21, 6, 3, 9, 5, 8, 2, 2, 30, 1};
        System.out.println("array = " + Arrays.toString(array));

        shellSort(array);
        System.out.println("array = " + Arrays.toString(array));

    }

    private static void shellSort(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int newElement = array[i];

                int j = i;
                while (j >= gap && array[j - gap] > newElement) {
                    array[j] = array[j - 1];
                    j -= gap;
                }
                array[j] = newElement;
            }
        }
    }
}
