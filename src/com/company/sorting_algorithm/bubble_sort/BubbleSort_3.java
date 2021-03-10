package com.company.sorting_algorithm.bubble_sort;

import java.util.Arrays;

public class BubbleSort_3 {
    public static void main(String[] args) {
 /*
        int[] array = {55, 8, 21, 6, 3, 9, 5, 8, 2, 2, 30, 1};
        System.out.println("array = " + Arrays.toString(array));
*/
        int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        int[] copiedArray = Arrays.copyOf(array, array.length);
        int[] copiedArray2 = Arrays.copyOf(array, array.length);

        System.out.println("array = " + Arrays.toString(array));
        long startTime = System.currentTimeMillis();
        bubbleSort1(array);
        System.out.println("array = " + Arrays.toString(array));
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("elapsedTime = " + elapsedTime);


        long startTime2 = System.currentTimeMillis();
        bubbleSort2(copiedArray);
        System.out.println("array2 = " + Arrays.toString(copiedArray));
        long stopTime2 = System.currentTimeMillis();
        long elapsedTime2 = stopTime2 - startTime2;
        System.out.println("elapsedTime 2 = " + elapsedTime2);

        long startTime3 = System.currentTimeMillis();
        bubbleSort2(copiedArray2);
        System.out.println("array3 = " + Arrays.toString(copiedArray2));
        long stopTime3 = System.currentTimeMillis();
        long elapsedTime3 = stopTime3 - startTime3;
        System.out.println("elapsedTime 3 = " + elapsedTime3);
    }

    private static void bubbleSort1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    int tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    static void bubbleSort2(int[] array) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }

    static void bubbleSort3(int arr[]) {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // IF no two elements were swapped by inner loop, then break
            if (!swapped)
                break;
        }
    }

}

