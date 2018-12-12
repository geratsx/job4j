package chess;

import chess.firuges.Cell;
import chess.firuges.Figure;

/**
 * Класс логику передижения фигур
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    /**
     * Массив сущестующих фигур на шахматной доске
     */
    private final Figure[] figures = new Figure[32];
    /**
     * Индекс последней добаленной фигуры в массив
     */
    private int index = 0;

    /**
     * Метод для добаления фигуры на игральную доску
     * @param figure фигура, которую нужно добаить на игроое поле
     */
    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    /**
     * Проверка занят ли путь, который должна пройти фигура
     * @param way массив ячеек, которые должна пройти фигура
     * @return true, если хотя бы в одной из ячеек пути нашей фигуры стоит любая другая фигура
     */
    private boolean isBusyWay(Cell[] way) {
        boolean result = false;
        for (int i = 0; i < way.length; i++) {
            Cell tmp = way[i];
            for (int j = 0; j < figures.length; j++) {
                if (figures[j].position().x == tmp.x && figures[j].position().y == tmp.y) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Реализация дижения фигуры
     * Если фигура не сущестует, путь фигуры занят или фигура не может так ходить,
     * выведет соответствующее предупреждение  консоль.
     * @param source ячейка, в которой стоит фигура
     * @param dest ячейка, в которую должна сходить фигура
     * @return true, если пройдены се проверки и фигура может ходить
     */
    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        try {
            int index = this.findBy(source);
            if (index != -1) {
                Cell[] steps = this.figures[index].way(source, dest);
                if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                    rst = true;
                    if (isBusyWay(steps)) {
                        throw new OccupiedWayException("Busy way!");
                    } else {
                        this.figures[index] = this.figures[index].copy(dest);
                    }
                }
            }
        } catch (ImposibleMoveException | FigureNotFoundException | OccupiedWayException oce) {
            System.out.println(oce.getMessage());
            rst = false;
        }
        return rst;
    }
    /**
     * Метод для очистки игроого поля от фигур(Заполняет null).
     */
    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }
    /**
     * Метод для поиска фигура на игроой доске
     * @param cell ячейка, в которой мы ожидаем найти фигуру
     * @throws FigureNotFoundException если ожидаемая фигура не найдена в заданной ячейке.
     * @return true, если фигура найдена  ожидаемой ячейке.
     */
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