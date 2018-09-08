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
        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            String tmp = array[i];
            if (tmp.equals(array[i + 1])) {
                array[i] = array[array.length - 1];
                array[array.length - 1] = tmp;
                array = Arrays.copyOf(array, array.length - 1);
            }
        }
        return array;
    }
}