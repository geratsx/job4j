package chess.firuges.exceptions;
/**
 * Класс реализует исключение когда фигура не найдена.
 * @see java.lang.RuntimeException
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FigureNotFoundException extends RuntimeException {
    public FigureNotFoundException(String message) {
        super(message);
    }
}
