package ru.job4j.tictactoe;

import java.util.function.Predicate;

/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 *
 * Класс Logic3T отвечает за проверку логики.
 */

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
     }

    /**
     * Проверяет победу крестиков.
     * @return True, если крестики победили.
     */
    public boolean isWinnerX() {
        return this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 0)
                || this.fillBy(Figure3T::hasMarkX, 0, 1, 1, 0)
                || this.fillBy(Figure3T::hasMarkX, 0, this.table.length - 1, 1, 0)
                || this.fillBy(Figure3T::hasMarkX, 0, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkX, 1, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkX, this.table.length - 1, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkX, 0, 0,  1,  1)
                || this.fillBy(Figure3T::hasMarkX, this.table.length - 1, 0, -1, 1);
    }
    /**
     * Проверяет победу ноликов.
     * @return True, если нолики победили.
     */
    public boolean isWinnerO() {
        return this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 0)
                || this.fillBy(Figure3T::hasMarkO, 0, 1, 1, 0)
                || this.fillBy(Figure3T::hasMarkO, 0, this.table.length - 1, 1, 0)
                || this.fillBy(Figure3T::hasMarkO, 0, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkO, 1, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkO, this.table.length - 1, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkO, 0, 0,  1,  1)
                || this.fillBy(Figure3T::hasMarkO, this.table.length - 1, 0, -1, 1);
    }

    /**
     * Проверяет диагональные, вертикальные или горизонтальные линии игрового поля
     * игры "крестики-нолики" на победную комбинацию.
     * @param predicate функциональный интерфейс для методов {@link Figure3T#hasMarkO()} и {@link Figure3T#hasMarkX()}
     * @param startX - координата X клетки игрового поля, откуда начинается проверка выигрышной линии
     * @param startY - координата O клетки игрового поля, откуда начинается проверка выигрышной линии
     * @param deltaX - напрвление движения по X проверки выигрышной линии
     * @param deltaY - напрвление движения по O проверки выигрышной линии
     * @return True, если крестики победили.
     */
    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Проверяет есть ли игровом поле не заполненные клетки.
     * @return False, если поле заполнено.
     */
    public boolean hasGap() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                Figure3T figure = table[i][j];
                if (!figure.hasMarkX() && !figure.hasMarkO()) {
                    return true;
                }
            }
        }
        return false;
    }
}