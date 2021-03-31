package com.company.sorting_algorithm.insertion_sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {55, 8, 21, 6, 3, 9, 5, 8, 2, 2, 30, 1};
        System.out.println("array = " + Arrays.toString(array));

        insertionSort2(array);
        System.out.println("array = " + Arrays.toString(array));
    }

    private static void insertionSort(int[] array) {
        // отже біжимо з 1 індексу (бо 0 вважаємо вже відсортованим) до кінця масиву
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++) {
            // запамятовуємо елемент
            int newElement = array[firstUnsortedIndex];
            // виносимо "і" поза блоком циклу, щоб пізніше мати доступ
            int i;

            // присвоюємо "і" цей черговий індекс, "і" поки більше 0 і попередній елемент масиву більший за елемент по цьому черговому індексу
            for (i = firstUnsortedIndex; i > 0 && array[i - 1] > newElement; i--) {
                //  знайти місце для вставки цього найменшого ел
                array[i] = array[i - 1];
            }
            //
            array[i] = newElement;
        }
    }

    private static void insertionSort2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int element = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > element) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = element;
        }
    }
}
