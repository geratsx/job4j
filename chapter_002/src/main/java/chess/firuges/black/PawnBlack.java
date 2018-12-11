package chess.firuges.black;

import chess.firuges.Cell;
import chess.firuges.Figure;
import chess.ImposibleMoveException;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PawnBlack implements Figure {
    private final Cell position;

    public PawnBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }


    private boolean checkWay(Cell source, Cell dest) {
        return source.y == dest.y + 1 && source.x == dest.x;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        boolean isRightWay = checkWay(source, dest);
        if (!isRightWay) {
            throw new ImposibleMoveException("Wrong way!");
        }
        return new Cell[]{dest};
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnBlack(dest);
    }
}

  /*- Что в заданной ячейки есть фигура. если нет. то выкинуть исключение
        есть  - Если фигура есть.
        есть -  Проверить может ли она так двигаться. Если нет то упадет исключение
          - Проверить что полученный путь. не занят фигурами. Если занят выкинуть исключение
          - Если все отлично. Записать в ячейку новое новое положение Figure figure.copy(Cell dest)*/