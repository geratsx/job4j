package ru.job4j.tracker;
import java.util.List;

/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 * <p>
 * <p>
 * Интерфейс декларирует поведение получения данных.
 */
public interface Input {

    /**
     * Метод реализует диалог с пользователем.
     *
     * @param question Вопрос пользователю.
     * @return ответ пользователя
     */
    String ask(String question);

    /**
     * Метод реализует диалог с пользователем.
     *
     * @param question Вопрос пользователю.
     * @param range    допустимый интервал ответов
     * @return ответ пользователя
     */
    int ask(String question, List<Integer> range);
}