package tracker;
/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 * Интерфейс декларирует поведение получения данных.
 */
public interface Input {

    /**
     * Метод реализует диалог с пользователем.
     * @param question Вопрос пользователю.
     */
    String ask(String question);

    /**
     * Метод реализует диалог с пользователем.
     * @param question Вопрос пользователю.
     * @param range допустимый интервал ответов
     */
    int ask(String question, int[] range);
}