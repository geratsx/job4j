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
        boolean result = false;
        int counter = 0;
        for (boolean temp : data) {
            counter = temp ? counter + 1 : counter - 1;
        }
       if (counter == 3 || counter == -3) {
           result = true;
       }
        return result;
    }
}