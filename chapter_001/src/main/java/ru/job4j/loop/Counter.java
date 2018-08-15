package ru.job4j.loop;

/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Counter {

    /**
     * Находит сумму всех четных чисел в диапазоне между 2 числами.
     *
     * @param start Начало диапазона.
     * @param finish Конец диапазона.
     * @return Сумма всех четных чисел в диапазоне.
     */
    public int add(int start, int finish) {
        int result = 0;

        for (int i = start; i <= finish; i++) {
           if (start % 2 == 0) {
               result += start;
           }
            ++start;
        }

        return result;
    }
}
