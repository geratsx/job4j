package pseudo;
/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 * <p>
 * Класс описывает сущность треугольник.
 */
public class Triangle implements Shape {
    /**
     * Метод создает строку для отрисовки треугольника в консоли.
     * @return Строковое представление треугольника
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("    +").append(System.lineSeparator());
        pic.append("  +   +").append(System.lineSeparator());
        pic.append(" +     +").append(System.lineSeparator());
        pic.append("+++++++++");
        return pic.toString();
    }
}