package ru.job4j.school;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 * <p>
 * Класс показывает применение stream api на примере школы и учеников.
 **/

public class School {

    /**
     * Метод отбор учеников по переданном условию.
     * @param students Коллекция студентов для отбора.
     * @param predicate Функция реализующая условие отбора учеников.
     * @return Лист студентов, полученный в результате отбора.
     **/
    public List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return students.stream().filter(predicate).collect(Collectors.toList());
    }
}

