package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.exceptions.ImposibleMoveException;

/**
 * Класс реализует шахматную фигуру - черная пешка.
 * @see Figure
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PawnBlack implements Figure {
    /**
     * Координаты ячейки, где находится фигура.
     */
    private final Cell position;

    public PawnBlack(final Cell position) {
        this.position = position;
    }

    /**
     * Метод для получения ячейки, в которой стоит фигура
     * @return ячейка, в которой стоит данная фигура
     */
    @Override
    public Cell position() {
        return this.position;
    }

    /**
     * Проверка может ли фигура так ходить
     * @param source ячейка, в которой стоит фигура
     * @param dest ячейка, в которую должна сходить фигура
     * @return true, если фигура может так ходить
     */
    private boolean checkWay(Cell source, Cell dest) {
        return source.y == dest.y + 1 && source.x == dest.x;
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
        return new PawnBlack(dest);
    }
}