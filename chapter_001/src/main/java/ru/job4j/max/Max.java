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

    /**
     * Находит большее число из трех.
     *
     * @param first Первое число.
     * @param second Второе число.
     * @param third Третье число.
     * @return Максимальное чисо из трех.
     */
    public int max(int first, int second, int third) {

        return this.max(this.max(first, second), third);
    }
}
