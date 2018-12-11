package chess;

import chess.firuges.Cell;
import chess.firuges.Figure;


/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    private boolean isBusyWay(Cell[] way) throws OccupiedWayException {
        boolean result = false;
        for (int i = 0; i < way.length - 1; i++) {
            Cell tmp = way[i];
            for (int j = 0; j < figures.length - 1; j++) {
                if (figures[j].position().x == tmp.x && figures[j].position().y == tmp.y) {
                    throw new OccupiedWayException("Busy way!");
                }
            }
        }
        return result;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        try {
            int index = this.findBy(source);
            if (index != -1) {
                Cell[] steps = this.figures[index].way(source, dest);
                if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                    rst = true;
                    if (!isBusyWay(steps)) {
                        this.figures[index] = this.figures[index].copy(dest);
                    }
                }
            }
        } catch (ImposibleMoveException ime) {
            System.out.println(ime.getMessage());
        } catch (FigureNotFoundException fe) {
            System.out.println(fe.getMessage());
        } catch (OccupiedWayException oce) {
            System.out.println(oce.getMessage());
        }
        return rst;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) { // если в этой ячейке есть фигура и там фигура та же, которую мы ищем
                rst = index;
                break;
            }

        }
        if (rst == -1) {
            throw new FigureNotFoundException("Figure not found!");
        }
        return rst;
    }
}