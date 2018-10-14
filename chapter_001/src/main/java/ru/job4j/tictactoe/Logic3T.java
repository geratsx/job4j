package ru.job4j.tictactoe;

/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 * <p>
 * Класс Logic3T отвечает за проверку логики.
 */

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }


    /**
     * Проверяет победу крестиков
     *
     * @return True, если крестики победили.
     */
    public boolean isWinnerX() {
        return isWinDiagonals(true) || isWinHorizontalOrVertical(true);
    }


    /**
     * Проверяет победу ноликов
     *
     * @return True, если нолики победили.
     */
    public boolean isWinnerO() {
        return isWinDiagonals(false) || isWinHorizontalOrVertical(false);
    }


    /**
     * Проверяет на победную комбинацию обе диагонали игрового поля
     *
     * @param isWinX если true, то проверяет победные комбинации на диаоналях для крестиков, false - для ноликов
     * @return True, если одна из диагоналей содержит победную комбинацию.
     */
    public boolean isWinDiagonals(boolean isWinX) {
        boolean secondaryDiagWin = true;
        boolean mainDiagWin = true;
        for (int outer = 0; outer < table.length; outer++) {
            if (isWinX) {
                if (!table[table.length - 1][0].hasMarkX() || !table[outer][table.length - 1 - outer].hasMarkX()) { // поменять на and
                    secondaryDiagWin = false;
                    for (int innerX = 0; innerX < table.length; innerX++) {
                        if (!table[0][0].hasMarkX() || !table[innerX][innerX].hasMarkX()) {
                            mainDiagWin = false;
                            break;
                        }
                    }
                    break;
                }
            } else {
                if (!table[table.length - 1][0].hasMarkO() || !table[outer][table.length - 1 - outer].hasMarkO()) {
                    secondaryDiagWin = false;
                    for (int innerO = 0; innerO < table.length; innerO++) {
                        if (!table[0][0].hasMarkO() || !table[innerO][innerO].hasMarkO()) {
                            mainDiagWin = false;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return secondaryDiagWin || mainDiagWin;
    }


    /**
     * Проверяет на победнкю комбинацию все вертикали и горизонтали игрового поля
     *
     * @param isWinX если true, то проверяет победные комбинации на вертикалях и горизонталях для ноликов, false - для крестиков.
     * @return True, если на одной из верикалей или горизантелей содержит победную комбинацию.
     */
    public boolean isWinHorizontalOrVertical(boolean isWinX) {
        boolean isVerticalWin = false;
        boolean isHorizontalWin = false;
        for (int i = 0; i < table.length; i++) {
            isVerticalWin = true;
            isHorizontalWin = true;
            for (int j = 0; j < table[i].length; j++) {
                if (isWinX) {
                    if (!table[i][j].hasMarkX()) {

                        isHorizontalWin = false;
                    }
                    if (!table[j][i].hasMarkX()) {
                        isVerticalWin = false;
                    }
                } else {
                    if (!table[i][j].hasMarkO()) {
                        isHorizontalWin = false;
                    }
                    if (!table[j][i].hasMarkO()) {
                        isVerticalWin = false;
                    }
                }
            }
            if (isVerticalWin || isHorizontalWin) {
                break;
            }
        }
        return isVerticalWin || isHorizontalWin;
    }

    /**
     * Проверяет есть ли игровом поле не заполненные клетки.
     *
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