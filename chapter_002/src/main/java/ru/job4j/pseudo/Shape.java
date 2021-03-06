package ru.job4j.pseudo;

/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 * Интерфейс описывает базовую реализацию фигуры.
 */
public interface Shape {

    /**
     * Метод создает строку для отрисовки фигуры.
     * @return Строковое представление фигуры
     */
    String draw();
}
