package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicate {


    /**
     * Удаляет дубликаты в массиве с помощью метода Arrays.copyOf.
     * @param array Исходный массив.
     * @return Массив без дубликатов.
     */
    public String[] remove(String[] array) {
        int border = array.length;
        for (int i = 0; i < border; i++) {
            for (int j = i + 1; j < border; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = array[border - 1];
                    border--;
                    j--;
                }
            }
        }
        array = Arrays.copyOf(array, border);
        return array;
    }
}