package ru.job4j.tictactoe;

import javafx.scene.shape.Rectangle;

/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 *
 * Класс отвечает за клетку на поле.
 * Он содержит методы - имеет ли клетка крестик или нолик, или пустая.
 */

public class Figure3T extends Rectangle {
    /**Стоит ли в ячейке X*/
    private boolean markX = false;
    /**Стоит ли в ячейке O*/
    private boolean markO = false;

    public Figure3T() {
    }

    public Figure3T(boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }

    public void take(boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }

    /**
     * Проверяет стоит ли X в ячейке  .
     * @return значение поля {@link Figure3T#markX}
     */
    public boolean hasMarkX() {
        return this.markX;
    }
    /**
     * Проверяет стоит ли O в ячейке  .
     * @return значение поля {@link Figure3T#markO}
     */
    public boolean hasMarkO() {
        return this.markO;
    }
}