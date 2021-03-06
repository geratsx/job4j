package ru.job4j.array;
/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FindLoop {

    /**
     * Находит индекс элемента в массиве.
     *
     * @param data Массив значений.
     * @param elem Искомый элемент.
     * @return Индекс элемента в массиве.
     */
    public int indexOf(int[] data, int elem) {
        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == elem) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}