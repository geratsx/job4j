package coffee;

/**
 * Класс реализует исключение для класса CoffeeMachine.
 * Выбрасвается если купюра меньше цены кофе.
 *
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SmallBillException extends RuntimeException {
    public SmallBillException(String message) {
        super(message);
    }
}