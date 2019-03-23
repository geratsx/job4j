package ru.job4j.chess.firuges.exceptions;
/**
 * Класс реализует исключение когда на пути, который должна пройти фигура, есть другие фигуры..
 * @see java.lang.RuntimeException
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class OccupiedWayException extends RuntimeException {
    public OccupiedWayException(String message) {
        super(message);
    }
}
