package tracker;
/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 * <p>
 *
 * Интерфейс декларирует поведение получения данных.
 */
public interface Input {

    /**
     * Метод реализует диалог с пользователем.
     * @param question Вопрос пользователю.
     */
    String ask(String question);
}