package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализует конвертер ArrayList в двумерный массив.
 *
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ConvertList2Array {

    /**
     * Метод равномерно конвертирует ArrayList в двухмерный массив.
     * Если в коллекции не хватает элементов для создания двумерного массива с равным количеством элементов,
     * то дополняет коллекцию нулями.
     *
     * @param list Коллекция, которую нужно конвертировать.
     * @param rows - Параметр указывает сколько подмассивов должно быть в результирующем массиве.
     * @return Двумерный массив из элементов исходной коллекции.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int arraySize = list.size();
        int cells = arraySize / rows;
        if (arraySize % rows != 0) {
            cells += 1;
        }
        int[][] array = new int[rows][cells];
        int outerIndex = 0;
        for (int[] arrayTmp : array) {
            int innerIndex = 0;
            for (int elemTmp : arrayTmp) {
                if (outerIndex < list.size()) {
                    arrayTmp[innerIndex++] = list.get(outerIndex++);
                }
            }
        }
        return array;
    }

    /**
     * Метод  конвертирует List массивов integer в List integer, где элементы в том же порядке.
     *
     * @param list Коллекция, которую нужно конвертировать.
     * @return List содержащий все числа из массивов входящего листа.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] arrayTmp : list) {
            for (int i = 0; i < arrayTmp.length; i++) {
                result.add(arrayTmp[i]);
            }
        }
        return result;
    }
}