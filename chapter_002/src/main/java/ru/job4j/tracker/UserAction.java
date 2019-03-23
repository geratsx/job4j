package ru.job4j.tracker;

/**
 * Интерфейс реализует базовую модель действий пользователя
 *
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface UserAction {

    /**
     * Метод позволяет узнать уникальный ключ пункиа меню
     * @return Возвращает уникальный ключ пункта меню
     */
    int key();

    /**
     * Метод выполняет действие пользователя
     * @param input ввод двнных
     * @param  tracker хранилище заявок
     */
    void execute(Input input, Tracker tracker);

    /**
     * Позволяет получить текст информацию о действии
     * @return Возвращает текстовую строку с информацией о действии пользователя
     */
    String info();
}
