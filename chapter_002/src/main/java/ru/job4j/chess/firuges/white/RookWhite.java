package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.exceptions.ImposibleMoveException;

/**
 * Класс реализует шахматную фигуру - белая ладья.
 * @see Figure
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class RookWhite implements Figure {
    /**
     * Координаты ячейки, где находится фигура.
     */
    private final Cell position;

    public RookWhite(final Cell position) {
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
        return (source.x != dest.x && source.y == dest.y)
                || (source.x == dest.x && source.y != dest.y);
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
        int deltaX = source.x - dest.x;
        int deltaY = source.y - dest.y;
        if (deltaX != 0) {
            deltaX = deltaX > 0 ? -1 : 1;
        }
        if (deltaY != 0) {
            deltaY = deltaY > 0 ? -1 : 1;
        }
        int stepX = source.x;
        int stepY = source.y;
        int size = source.x != dest.x ? Math.abs(dest.x - source.x) : Math.abs(dest.y - source.y);
        Cell[] steps = new Cell[size];

        if (!isRightWay) {
            throw new ImposibleMoveException("Wrong way!");
        } else {
            for (int i = 0; i < steps.length; i++) {
                stepX += deltaX;
                stepY += deltaY;
                steps[i] = Cell.values()[8 * stepX + stepY];
            }
        }
        return steps;
    }

    /**
     * Метод эмулирующий передижение фигуры.
     * Создается новая фигура с координатами ячейки, куда фигура должна стать.
     * @param dest ячейка, в которую должна сходить фигура
     * @return фигура с координатами ячейки, в которую должна сходить
     */
    @Override
    public Figure copy(Cell dest) {
        return new RookWhite(dest);
    }
}