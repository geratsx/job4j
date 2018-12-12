package chess;

import chess.firuges.Cell;
import chess.firuges.black.BishopBlack;
import chess.firuges.black.PawnBlack;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
    public void ifPawnBlackNotFoundThenException() {
        Logic logic = new Logic();
        PawnBlack pawn = new PawnBlack(Cell.A1);
        Cell source = pawn.position();
        Cell dest = Cell.B1;
        logic.move(source, dest);
        assertThat(this.mem.toString(), is("Figure not found!\r\n"));
    }
    @Test
    public void ifBishopBlackNotFoundThenException() {
        Logic logic = new Logic();
        BishopBlack bishop = new BishopBlack(Cell.A1);
        Cell source = bishop.position();
        Cell dest = Cell.E6;
        logic.move(source, dest);
        assertThat(this.mem.toString(), is("Figure not found!\r\n"));
    }

    @Test(expected = ImposibleMoveException.class)
    public void ifWayOfPawnBlackIsImpossibleThenException() {
        PawnBlack pawn = new PawnBlack(Cell.A8);
        Cell source = pawn.position();
        Cell dest = Cell.B1;
        pawn.way(source, dest);
    }

    @Test(expected = ImposibleMoveException.class)
    public void ifWayOfBishopBlackIsImpossibleThenException() {
        BishopBlack bishop = new BishopBlack(Cell.A8);
        Cell source = bishop.position();
        Cell dest = Cell.A1;
        bishop.way(source, dest);
    }

    @Test
    public void ifWayOfPawnBlackIsPossibleThenOk() {
        PawnBlack pawn = new PawnBlack(Cell.A7);
        Cell source = pawn.position();
        Cell dest = Cell.A6;
        Cell[] expected = new Cell[]{dest};
        assertThat(pawn.way(source, dest), is(expected));
    }

    @Test
    public void ifWayOfBishopBlackIsPossibleThenOk() {
        BishopBlack bishop = new BishopBlack(Cell.C8);
        Cell source = bishop.position();
        Cell dest = Cell.E6;
        Cell[] expected = new Cell[]{Cell.D7, Cell.E6};
        assertThat(bishop.way(source, dest), is(expected));
    }

    @Test
    public void ifWayOfPawnBlackIsBusyThenException() {
        Logic logic = new Logic();
        PawnBlack pawn = new PawnBlack(Cell.A7);
        PawnBlack pawn2 = new PawnBlack(Cell.A6);
        logic.add(pawn);
        logic.add(pawn2);
        Cell source = pawn.position();
        Cell dest = Cell.A6;
        pawn.way(source, dest);
        logic.move(source, dest);
        assertThat(this.mem.toString(), is("Busy way!\r\n"));
    }

    @Test
    public void ifWayOfBishopBlackIsBusyThenException() {
        Logic logic = new Logic();
        BishopBlack bishop = new BishopBlack(Cell.C8);
        PawnBlack pawn1 = new PawnBlack(Cell.E6);
        PawnBlack pawn2 = new PawnBlack(Cell.A7);
        PawnBlack pawn3 = new PawnBlack(Cell.B7);
        PawnBlack pawn4 = new PawnBlack(Cell.D7);
        PawnBlack pawn5 = new PawnBlack(Cell.E7);
        PawnBlack pawn6 = new PawnBlack(Cell.F7);
        PawnBlack pawn7 = new PawnBlack(Cell.G7);
        PawnBlack pawn8 = new PawnBlack(Cell.H7);
        PawnBlack pawn9 = new PawnBlack(Cell.A8);
        PawnBlack pawn10 = new PawnBlack(Cell.B8);
        PawnBlack pawn11 = new PawnBlack(Cell.D8);
        PawnBlack pawn12 = new PawnBlack(Cell.E8);
        PawnBlack pawn13 = new PawnBlack(Cell.F8);
        PawnBlack pawn14 = new PawnBlack(Cell.G8);
        PawnBlack pawn15 = new PawnBlack(Cell.H8);
        logic.add(bishop);
        logic.add(pawn1);
        logic.add(pawn2);
        logic.add(pawn3);
        logic.add(pawn4);
        logic.add(pawn5);
        logic.add(pawn6);
        logic.add(pawn7);
        logic.add(pawn8);
        logic.add(pawn9);
        logic.add(pawn10);
        logic.add(pawn11);
        logic.add(pawn12);
        logic.add(pawn13);
        logic.add(pawn14);
        logic.add(pawn15);
        Cell source = bishop.position();
        Cell dest = Cell.E6;
        bishop.way(source, dest);
        logic.move(source, dest);
        assertThat(this.mem.toString(), is("Busy way!\r\n"));
    }
}