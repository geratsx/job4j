package ru.job4j.tracker;

/**
 * Класс предоставляет реализацию некоторых методов интерфейса/
 *
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @see UserAction
 * @since 0.1
 */
public abstract class BaseAction implements UserAction {

    /**
     * Пункт меню
     */
    private final int key;
    /**
     * Описание пункта меню
     */
    private final String name;


    public BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }

    /**
     * Метод дает возможность получить ключ пункта меню.
     * @return ключ пункта меню
     */
    @Override
    public int key() {
        return this.key;
    }

    /**
     * Метод дает возможность получить описание пункта меню.
     * @return форматированная строка, содержащая номер пункта меню и его описание.
     */
    @Override
    public String info() {
        return String.format("%s.%s", this.key, this.name);
    }

    /**
     * @see UserAction
     */
    @Override
    public abstract void execute(Input input, Tracker tracker);
}