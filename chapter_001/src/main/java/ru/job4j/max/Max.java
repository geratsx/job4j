package ru.job4j.max;

/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Max {

    /**
     * Находит большее число из двух.
     *
     * @param first Первое число.
     * @param second Второе число.
     * @return Максимальное чисо из двух.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

}
