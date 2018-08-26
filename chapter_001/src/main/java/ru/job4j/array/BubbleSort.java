package ru.job4j.array;

/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 *
 * Пузарьковая сортировка массива.
 *
 */
public class BubbleSort {

    /**
     * Сортирует массив пузырьковой сортировкой
     * @param array Не отсортированный массив.
     * @return Отсортированный массив
     */
    public int[] sort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }
}
