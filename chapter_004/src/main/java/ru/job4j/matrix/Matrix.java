package ru.job4j.matrix;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 * <p>
 * Класс показывает применение stream api на примере матрицы.
 **/
public class Matrix {
    /**
     * Метод превращает двумерный массив числе в список.
     * @param matrix Двумерный массив чисел для преобразования.
     * @return Лист чисел, полученный из двумерного масива.
     **/
    public List<Integer> getListFromMatrixOfNumbers(Integer[][] matrix) {
        return Arrays.stream(matrix).flatMap(Arrays::stream).collect(Collectors.toList());
    }
}