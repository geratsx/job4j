package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.exceptions.ImposibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Класс реализует шахматную фигуру - черный король.
 *
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @see Figure
 * @since 0.1
 */
public class KingBlack implements Figure {
    /**
     * Координаты ячейки, где находится фигура.
     */
    private final Cell position;

    public KingBlack(final Cell position) {
        this.position = position;
    }

    /**
     * Метод для получения ячейки, в которой стоит фигура
     *
     * @return ячейка, в которой стоит данная фигура
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
    private boolean checkWay(Cell source, Cell dest) {
        return ((Math.abs(source.x - dest.x) == 1) && (Math.abs(source.y - dest.y) == 0))
                || ((Math.abs(source.x - dest.x) == 0) && (Math.abs(source.y - dest.y) == 1))
                || ((Math.abs(source.x - dest.x) == 1) && (Math.abs(source.y - dest.y) == 1));
    }

    /**
     * Метод для получения пути, который должна пройти фигура
     * @param source ячейка, в которой стоит фигура
     * @param dest ячейка, в которую должна сходить фигура
     * @throws ImposibleMoveException, если фигура не может так ходить
     * @return массив ячеек, пройденных фигурой
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
     * @param dest ячейка, в которую должна сходить фигура
     * @return фигура с координатами ячейки, в которую должна сходить
     */
    @Override
    public Figure copy(Cell dest) {
        return new KingBlack(dest);
    }
}