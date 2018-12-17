package chess.firuges.exceptions;
/**
 * Класс реализует исключение когда фигура не может так ходить.
 * @see java.lang.RuntimeException
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ImposibleMoveException extends RuntimeException {
    public ImposibleMoveException(String message) {
        super(message);
    }
}
