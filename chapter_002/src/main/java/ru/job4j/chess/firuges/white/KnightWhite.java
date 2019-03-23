package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.exceptions.ImposibleMoveException;

/**
 * Класс реализует шахматную фигуру - белый конь.
 *
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @see Figure
 * @since 0.1
 */
public class KnightWhite implements Figure {
    /**
     * Координаты ячейки, где находится фигура.
     */
    private final Cell position;

    public KnightWhite(final Cell position) {
        this.position = position;
    }

    /**
     * Метод для получения ячейки, в которой стоит фигура
     *
     * @return ячека, в которой стоит данная фигура
     */
    @Override
    public Cell position() {
        return this.position;
    }

    /**
     * Проверка может ли фигура так ходить
     *
     * @param source ячейка, в которой стоит фигура
     * @param dest   ячейка, в которую должна сходить фигура
     * @return true, если фигура может так ходить
     */
    public boolean checkWay(Cell source, Cell dest) {
        return ((Math.abs(source.x - dest.x) == 2) && (Math.abs(source.y - dest.y) == 1))
                || ((Math.abs(source.x - dest.x) == 1) && (Math.abs(source.y - dest.y) == 2));
    }

    /**
     * Метод для получения пути, который должна пройти фигура
     *
     * @param source ячейка, в которой стоит фигура
     * @param dest   ячейка, в которую должна сходить фигура
     * @return массив ячеек, пройденных фигурой
     * @throws ImposibleMoveException, если фигура не может так ходить
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        boolean isRightWay = checkWay(source, dest);
        if (!isRightWay) {
            throw new ImposibleMoveException("Wrong way!");
        }
        return new Cell[]{dest};
    }

    /**
     * Метод эмулирующий передижение фигуры.
     * Создается новая фигура с координатами ячейки, куда фигура должна стать.
     *
     * @param dest ячейка, в которую должна сходить фигура
     * @return фигура с координатами ячейки, в которую должна сходить
     */
    @Override
    public Figure copy(Cell dest) {
        return new KnightWhite(dest);
    }
}