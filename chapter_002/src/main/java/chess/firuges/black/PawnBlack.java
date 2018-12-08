package chess.firuges.black;

import chess.OccupiedWayException;
import chess.firuges.Cell;
import chess.firuges.Figure;
import chess.ImposibleMoveException;

/**
 *
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


    public boolean checkWay(Cell source, Cell dest) throws ImposibleMoveException, OccupiedWayException {
        boolean result = source.y == dest.y + 1 && source.x == dest.x;
        if (!result) {
            throw new ImposibleMoveException("Wrong way!");
        }
        return result;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException, OccupiedWayException {
        Cell[] steps = new Cell[0];
            boolean isRightWay = checkWay(source, dest);
            if (isRightWay) {
                steps = new Cell[]{dest};
            }
        return steps;
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