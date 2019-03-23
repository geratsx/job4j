package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;
/**
 * Класс реализует конвертер двумерного массива в List.
 *
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ConvertMatrix2List {
    /**
     * Метод конвертирует двумерный массив в ArrayLis.
     *
     * @param array Двумерный массив, который надо конвертировать в List.
     * @return List созданный из элементов переданного массива.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] arrayTmp : array) {
            for (int tmp : arrayTmp) {
                list.add(tmp);
            }
        }
        return list;
    }
}