package ru.job4j.loop;

/**
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Paint {

    /**
     * Рисует Пирамиду.
     *
     * @param height высота пирамиды
     * @return Пирамида.
     */
    public String pyramid(int height) {
        StringBuilder screen = new StringBuilder();
        int weight = 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= height - column - 1 && row + height - 1 >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

    /**
     * Рисует правую часть пирамиды.
     *
     * @param height высота пирамиды
     * @return Правая часть пирамиды.
     */

    public String rightTrl(int height) {
        StringBuilder screen = new StringBuilder();
        int weight = height;

        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }


    /**
     * Рисует левую часть пирамиды.
     *
     * @param height высота пирамиды
     * @return Левая часть пирамиды.
     */

    public String leftTrl(int height) {
        StringBuilder screen = new StringBuilder();
        int weight = height;

        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= weight - column - 1) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
