package ru.job4j.tracker;

/**
 * Класс реализует исключение при работе с меню
 * @see java.lang.RuntimeException
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MenuOutException extends RuntimeException {

    public MenuOutException(String message) {
        super(message);
    }
}
