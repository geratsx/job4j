package list;

import java.util.ArrayList;

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
    public int[][] toArray(ArrayList<Integer> list, int rows) {
        int arraySize = list.size();
        while (arraySize % rows != 0) {
            arraySize++;
        }
        int cells = arraySize / rows;
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
}