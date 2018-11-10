package pseudo;
/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 * <p>
 * Класс описывает сущность квадрат.
 */
public class Square implements Shape {

    /**
     * Метод создает строку для отрисовки квадрата в консоли.
     * @return Строковое представление квадрата
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append(" +++++++").append(System.lineSeparator());
        pic.append(" +     +").append(System.lineSeparator());
        pic.append(" +     +").append(System.lineSeparator());
        pic.append(" +++++++");
        return pic.toString();
    }
}
