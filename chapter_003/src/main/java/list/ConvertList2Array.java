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
        if (arraySize % rows > 0) {
            int el = rows - (arraySize % rows);
            for (int i = arraySize; i != arraySize + el; i++) {
                list.add(0);
            }
        }
        int cells = list.size() / rows;
        int[][] array = new int[rows][cells];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
                array[i][j] = list.get(index);
                index++;
            }
        }
        return array;
    }
}