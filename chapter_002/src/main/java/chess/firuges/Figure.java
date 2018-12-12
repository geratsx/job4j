package chess.firuges;
/**
 * Интерфейс, описывающий абстрактную фигуру.
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface Figure {

    /**
     * Метод для получения ячейки, в которой стоит фигура
     * @return ячека, в которой стоит данная фигура
     */
    Cell position();
    /**
     * Метод для получения пути, который должна пройти фигура
     * @param source ячейка, в которой стоит фигура
     * @param dest ячейка, в которую должна сходить фигура
     * @return массив ячеек, пройденных фигурой
     */
    Cell[] way(Cell source, Cell dest);

    /**
     * Метод для получения имени изображения фигуры для представления ее на игровом поле
     * @return полное назания файла картинки
     */
    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }
    /**
     * Метод эмулирующий передижение фигуры.
     * @param dest ячейка, в которую должна сходить фигура
     * @return фигура с координатами ячейки, в которую должна сходить
     */
    Figure copy(Cell dest);
}