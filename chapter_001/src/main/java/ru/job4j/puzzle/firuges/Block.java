package ru.job4j.puzzle.firuges;
/**
 * Фигура, которую нельзя двигать
 *
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Block implements Figure {
    private final Cell position;

    public Block(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        return new Cell[0];
    }

    @Override
    public Figure copy(Cell dest) {
        throw new IllegalStateException("Block could not move.");
    }

    @Override
    public boolean movable() {
        return false;
    }
}