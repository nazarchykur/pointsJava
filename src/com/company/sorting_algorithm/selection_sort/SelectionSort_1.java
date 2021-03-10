package com.company.sorting_algorithm.selection_sort;

import java.util.Arrays;

/*
ЛГОРИТМ СОРТУВАННЯ ВИБОРОМ

знайти мінімальний елемент і поміняти його місцями з початковим, потім,
в решти масиву (крім першого елемента), знайти знову мінімальний елемент
і поміняти його з другим елементом і т.д.
*/
public class SelectionSort_1 {
    public static void main(String[] args) {
        int[] array = {55, 8, 21, 6, 3, 9, 5, 8, 2, 2, 30, 1};
        System.out.println("array = " + Arrays.toString(array));

        selectionSort(array);
        System.out.println("array = " + Arrays.toString(array));

    }

    public static void selectionSort(int[] arr) {
        
    /* По черзі будемо переглядати всі підмножини елементів масиву
     (0 - Останній, 1-останній, 2-останній, ...) */
        for (int i = 0; i < arr.length; i++) {
            /* Припускаємо, що перший елемент (в кожній підмножині елементів)
             Є мінімальним  */
            int min = arr[i];
            int min_index = i;
            
            /*  У решти підмножини шукаємо елемент, який менше
            Припущеного мінімуму */
            for (int j = i + 1; j < arr.length; j++) {
                // Якщо знаходимо, запам'ятовуємо його індекс
                if (arr[j] < min) {
                    min = arr[j];
                    min_index = j;
                }
            }

            /* Якщо знайшовся елемент, менший, ніж на поточній позиції, міняємо їх місцями */
            if (i != min_index) {
                int tmp = arr[i];
                arr[i] = arr[min_index];
                arr[min_index] = tmp;
            }
        }
    }

}
