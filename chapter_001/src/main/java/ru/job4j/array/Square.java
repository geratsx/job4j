package ru.job4j.array;

/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Square {

    /**
     * Заполняет массив числами возведенными в квадрат.
     *
     * @param bound Кол-во элементов в массиве
     * @return Массив с возведенными в квадрат значениями.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 1; i <= bound; i++) {
            rst[i - 1] = (int) Math.pow(i, 2);
        }
        return rst;
    }
}