package chess;

import chess.firuges.Cell;
import chess.firuges.black.PawnBlack;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ChessTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void ifFigureNotFoundThenException() {
        Logic logic = new Logic();
        Cell source = Cell.A1;
        Cell dest = Cell.B1;
        logic.move(source, dest);
        assertThat(this.mem.toString(), is("Figure not found!\r\n"));
    }


    @Test(expected = ImposibleMoveException.class)
    public void ifWayIsImpossibleThenException() {
        PawnBlack pawn = new PawnBlack(Cell.A8);
        Cell source = pawn.position();
        Cell dest = Cell.B1;
        pawn.way(source, dest);
    }

    @Test
    public void ifWayIsPossibleThenOk() {
        PawnBlack pawn = new PawnBlack(Cell.A7);
        Cell source = pawn.position();
        Cell dest = Cell.A6;
        Cell[] expected = new Cell[]{dest};
        assertThat(pawn.way(source, dest), is(expected));
    }

    /*@Test(expected = OccupiedWayException.class)
    public void ifWayIsBusyThenException() {

        Logic logic = new Logic();
        PawnBlack pawn = new PawnBlack(Cell.A7);
        PawnBlack pawn2 = new PawnBlack(Cell.A6);

        logic.add(pawn2);
        Cell source = pawn.position();
        Cell dest = Cell.A6;
        pawn.way(source, dest);
//        assertThat(pawn.way(source, dest), is(expected));
    }*/
}
