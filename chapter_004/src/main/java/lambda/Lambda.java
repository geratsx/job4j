package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 * <p>
 * Класс создан для демонстрации универсальности лямбда выражения.
 **/
public class Lambda {

    /**
     * Метод реализует подсчет функции в диапазоне
     * @param start Начало диапазона функции.
     * @param end Конец диапфзона функции.
     * @param function Функция для подсчета
     * @return Лист значений, полученных в результате подсчета функции в диапазоне.
     **/
    List<Double> diapason(int start, int end, Function<Double, Double> function) {
        List<Double> result = new ArrayList<>();
        for (int i = start; i != end; i++) {
            result.add(function.apply((double) i));
        }
        return result;
    }
}
