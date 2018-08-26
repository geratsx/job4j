package ru.job4j.array;

/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 *
 * Таблица умножения в матрице
 *
 */
public class Matrix {


    /**
     * Создает таблицу умножения в виде матрицы.
     * @param size Размер таблицы умножения.
     * @return Таблица умножения.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}