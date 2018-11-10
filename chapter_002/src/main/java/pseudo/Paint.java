package pseudo;
/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 * <p>
 * Класс рисует фигуры в консоли.
 */
public class Paint {

    /**
     * Метод печатает в консоль фигуру
     * @param shape - фигура для печати
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Square());
        System.out.println();
        paint.draw(new Triangle());
    }
}
