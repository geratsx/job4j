package chess.firuges.black;


import chess.ImposibleMoveException;
import chess.firuges.Cell;
import chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }


    public boolean checkWay(Cell source, Cell dest) {
        return (source.x > dest.x && source.y < dest.y)
                || (source.x > dest.x && source.y > dest.y)
                || (source.x < dest.x && source.y < dest.y)
                || (source.x < dest.x && source.y > dest.y);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        boolean isRightWay = checkWay(source, dest);
        int deltaX = source.x - dest.x > 0 ? -1 : 1;
        int deltaY = source.y - dest.y > 0 ? -1 : 1;
        int size = Math.abs(dest.y - source.y);
        int stepX = source.x;
        int stepY = source.y;
        Cell[] steps = new Cell[size];

        if (!isRightWay) {
            throw new ImposibleMoveException("Wrong way!");
        } else {
            for (int i = 0; i < steps.length; i++) {
                stepX += deltaX;
                stepY += deltaY;
                steps[i] = Cell.values()[8 * stepX + stepY];
            }

            // 4 4   3 5   0 7  4 -3 вверх право
            // 4 4   3 3   0 1   4 3 вверх влево
            // 4 4   5 5   6 6  -3 -3 вниз вправо
            // 4 4   3 5   0 7  4 -4 вниз влево

//        }
        }


        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}