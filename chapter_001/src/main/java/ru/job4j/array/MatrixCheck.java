package ru.job4j.array;


/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class MatrixCheck {
    /**
     * Проверяет равентсво элементов диагонали матрицы друг другу
     *
     * @param data Исходный массив.
     * @return Результат проверки.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
            for (int i = 0; i < data.length; i++) {
                if (data[0][0] != data[i][i]) {
                    result = false;
                    break;
                }
                if (data[data.length - 1][0] != data[i][data.length - 1 - i]) {
                    result = false;
                    break;
                }
            }
            return result;
    }
}