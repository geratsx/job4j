package sort;

import java.util.Comparator;
/**
 * Класс реализует компаратор для строк.
 *
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ListCompare implements Comparator<String> {

    /**
     * Метод посимвольно сравнивает строки.
     *
     * @param left Первая строка
     * @param right Вторая строка
     * @return Возвращает 0 если строки равны, значение больше 0, если первая строка больше,
     * и значение меньше 0, если первая строка меньше.
     */
    @Override
    public int compare(String left, String right) {
        int minLenght = Math.min(left.length(), right.length());
        int index = 0;
        while (index < minLenght) {
        char leftChar = left.charAt(index);
        char rightChar = right.charAt(index);
            if (leftChar != rightChar) {
               return leftChar - rightChar;
            }
                index++;
        }
        return left.length() - right.length();
    }
}