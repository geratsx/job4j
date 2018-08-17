package ru.job4j.loop;

/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Factorial {

    /**
     * Вычисляет факториал числа.
     *
     * @param n число для вычисление факториала
     * @return Факториал.
     */
    public int calc(int n) {
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
