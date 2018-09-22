package ru.job4j.array;

/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Check {

    /**
     * Проверяет что все значение массива true или false.
     *
     * @param data Исходный массив
     * @return Результат проверки. Все элементы массива равны true или все равны false - вернет true, иначе вернет false.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 1; i < data.length; i++) {
            if (data[i] != data[0]) {
                result = false;
                break;
            }
        }
        return result;
    }
}