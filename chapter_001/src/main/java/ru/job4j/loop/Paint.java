package ru.job4j.loop;

import java.util.function.BiPredicate;

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
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }

    /**
     * Рисует правую часть пирамиды.
     *
     * @param height высота пирамиды
     * @return Правая часть пирамиды.
     */

    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }


    /**
     * Рисует левую часть пирамиды.
     *
     * @param height высота пирамиды
     * @return Левая часть пирамиды.
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }

    /**
     * Рисует символами ^ и пробелами.
     *
     * @param height высота пирамиды
     * @param weight ширина пирамиды
     * @param predict предикат
     * @return Строку из символов ^ и пробелов.
     */
    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
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
