package chess;

import chess.firuges.Cell;
import chess.firuges.black.*;
import chess.firuges.exceptions.ImposibleMoveException;
import chess.firuges.white.*;
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

    @Test
    public void ifRookBlackNotFoundThenException() {
        Logic logic = new Logic();
        RookBlack rook = new RookBlack(Cell.H8);
        Cell source = rook.position();
        Cell dest = Cell.H7;
        logic.move(source, dest);
        assertThat(this.mem.toString(), is("Figure not found!\r\n"));
    }

    @Test
    public void ifQueenBlackNotFoundThenException() {
        Logic logic = new Logic();
        QueenBlack queen = new QueenBlack(Cell.E8);
        Cell source = queen.position();
        Cell dest = Cell.H7;
        logic.move(source, dest);
        assertThat(this.mem.toString(), is("Figure not found!\r\n"));
    }

    @Test
    public void ifKingBlackNotFoundThenException() {
        Logic logic = new Logic();
        KingBlack king = new KingBlack(Cell.E8);
        Cell source = king.position();
        Cell dest = Cell.H7;
        logic.move(source, dest);
        assertThat(this.mem.toString(), is("Figure not found!\r\n"));
    }

    @Test
    public void ifKhightBlackNotFoundThenException() {
        Logic logic = new Logic();
        KnightBlack knight = new KnightBlack(Cell.B8);
        Cell source = knight.position();
        Cell dest = Cell.H7;
        logic.move(source, dest);
        assertThat(this.mem.toString(), is("Figure not found!\r\n"));
    }

    @Test
    public void ifPawnWhiteNotFoundThenException() {
        Logic logic = new Logic();
        PawnWhite pawn = new PawnWhite(Cell.A2);
        Cell source = pawn.position();
        Cell dest = Cell.B1;
        logic.move(source, dest);
        assertThat(this.mem.toString(), is("Figure not found!\r\n"));
    }

    @Test
    public void ifBishopWhiteNotFoundThenException() {
        Logic logic = new Logic();
        BishopWhite bishop = new BishopWhite(Cell.C1);
        Cell source = bishop.position();
        Cell dest = Cell.E6;
        logic.move(source, dest);
        assertThat(this.mem.toString(), is("Figure not found!\r\n"));
    }

    @Test
    public void ifRookWhiteNotFoundThenException() {
        Logic logic = new Logic();
        RookWhite rook = new RookWhite(Cell.A1);
        Cell source = rook.position();
        Cell dest = Cell.H7;
        logic.move(source, dest);
        assertThat(this.mem.toString(), is("Figure not found!\r\n"));
    }

    @Test
    public void ifQueenWhiteNotFoundThenException() {
        Logic logic = new Logic();
        QueenWhite queen = new QueenWhite(Cell.D1);
        Cell source = queen.position();
        Cell dest = Cell.H7;
        logic.move(source, dest);
        assertThat(this.mem.toString(), is("Figure not found!\r\n"));
    }

    @Test
    public void ifKingWhiteNotFoundThenException() {
        Logic logic = new Logic();
        KingWhite king = new KingWhite(Cell.E1);
        Cell source = king.position();
        Cell dest = Cell.H7;
        logic.move(source, dest);
        assertThat(this.mem.toString(), is("Figure not found!\r\n"));
    }

    @Test
    public void ifKhightWhiteNotFoundThenException() {
        Logic logic = new Logic();
        KnightWhite knight = new KnightWhite(Cell.B1);
        Cell source = knight.position();
        Cell dest = Cell.H7;
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

    @Test(expected = ImposibleMoveException.class)
    public void ifWayOfRookBlackIsImpossibleThenException() {
        RookBlack rook = new RookBlack(Cell.H8);
        Cell source = rook.position();
        Cell dest = Cell.G7;
        rook.way(source, dest);
    }

    @Test(expected = ImposibleMoveException.class)
    public void ifWayOfKingBlackIsImpossibleThenException() {
        KingBlack king = new KingBlack(Cell.E8);
        Cell source = king.position();
        Cell dest = Cell.G7;
        king.way(source, dest);
    }

    @Test(expected = ImposibleMoveException.class)
    public void ifWayOfKnightBlackIsImpossibleThenException() {
        KnightBlack knight = new KnightBlack(Cell.B8);
        Cell source = knight.position();
        Cell dest = Cell.G7;
        knight.way(source, dest);
    }

    @Test(expected = ImposibleMoveException.class)
    public void ifWayOfWhiteBlackIsImpossibleThenException() {
        PawnWhite pawn = new PawnWhite(Cell.A2);
        Cell source = pawn.position();
        Cell dest = Cell.B3;
        pawn.way(source, dest);
    }

    @Test(expected = ImposibleMoveException.class)
    public void ifWayOfBishopWhiteIsImpossibleThenException() {
        BishopWhite bishop = new BishopWhite(Cell.C1);
        Cell source = bishop.position();
        Cell dest = Cell.C2;
        bishop.way(source, dest);
    }

    @Test(expected = ImposibleMoveException.class)
    public void ifWayOfRookWhiteIsImpossibleThenException() {
        RookWhite rook = new RookWhite(Cell.A1);
        Cell source = rook.position();
        Cell dest = Cell.B2;
        rook.way(source, dest);
    }

    @Test(expected = ImposibleMoveException.class)
    public void ifWayOfKingWhiteIsImpossibleThenException() {
        KingWhite king = new KingWhite(Cell.E1);
        Cell source = king.position();
        Cell dest = Cell.E3;
        king.way(source, dest);
    }

    @Test(expected = ImposibleMoveException.class)
    public void ifWayOfKnightWhiteIsImpossibleThenException() {
        KnightWhite knight = new KnightWhite(Cell.B1);
        Cell source = knight.position();
        Cell dest = Cell.G7;
        knight.way(source, dest);
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
    public void ifWayOfRookBlackIsPossibleThenOk() {
        RookBlack rook = new RookBlack(Cell.H8);
        Cell source = rook.position();
        Cell dest = Cell.H5;
        Cell[] expected = new Cell[]{Cell.H7, Cell.H6, Cell.H5};
        assertThat(rook.way(source, dest), is(expected));
    }

    @Test
    public void ifWayOfQueenBlackIsPossibleThenOk() {
        QueenBlack queen = new QueenBlack(Cell.D8);
        Cell source = queen.position();
        Cell dest = Cell.F6;
        Cell[] expected = new Cell[]{Cell.E7, Cell.F6};
        assertThat(queen.way(source, dest), is(expected));
    }

    @Test
    public void ifWayOfKingBlackIsPossibleThenOk() {
        KingBlack king = new KingBlack(Cell.E8);
        Cell source = king.position();
        Cell dest = Cell.E7;
        Cell[] expected = new Cell[]{Cell.E7};
        assertThat(king.way(source, dest), is(expected));
    }

    @Test
    public void ifWayOfKnightBlackIsPossibleThenOk() {
        KnightBlack knight = new KnightBlack(Cell.B8);
        Cell source = knight.position();
        Cell dest = Cell.C6;
        Cell[] expected = new Cell[]{Cell.C6};
        assertThat(knight.way(source, dest), is(expected));
    }

    @Test
    public void ifWayOfPawnWhiteIsPossibleThenOk() {
        PawnWhite pawn = new PawnWhite(Cell.A2);
        Cell source = pawn.position();
        Cell dest = Cell.A3;
        Cell[] expected = new Cell[]{dest};
        assertThat(pawn.way(source, dest), is(expected));
    }

    @Test
    public void ifWayOfBishopWhiteIsPossibleThenOk() {
        BishopWhite bishop = new BishopWhite(Cell.C1);
        Cell source = bishop.position();
        Cell dest = Cell.A3;
        Cell[] expected = new Cell[]{Cell.B2, Cell.A3};
        assertThat(bishop.way(source, dest), is(expected));
    }

    @Test
    public void ifWayOfRookWhiteIsPossibleThenOk() {
        RookWhite rook = new RookWhite(Cell.A1);
        Cell source = rook.position();
        Cell dest = Cell.A3;
        Cell[] expected = new Cell[]{Cell.A2, Cell.A3};
        assertThat(rook.way(source, dest), is(expected));
    }

    @Test
    public void ifWayOfQueenWhiteIsPossibleThenOk() {
        QueenWhite queen = new QueenWhite(Cell.D1);
        Cell source = queen.position();
        Cell dest = Cell.D3;
        Cell[] expected = new Cell[]{Cell.D2, Cell.D3};
        assertThat(queen.way(source, dest), is(expected));
    }

    @Test
    public void ifWayOfKingWhiteIsPossibleThenOk() {
        KingWhite king = new KingWhite(Cell.E1);
        Cell source = king.position();
        Cell dest = Cell.E2;
        Cell[] expected = new Cell[]{Cell.E2};
        assertThat(king.way(source, dest), is(expected));
    }

    @Test
    public void ifWayOfKnightWhiteIsPossibleThenOk() {
        KnightWhite knight = new KnightWhite(Cell.B1);
        Cell source = knight.position();
        Cell dest = Cell.D2;
        Cell[] expected = new Cell[]{Cell.D2};
        assertThat(knight.way(source, dest), is(expected));
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
    public void ifWayOfRookBlackIsBusyThenException() {
        Logic logic = new Logic();
        RookBlack rook = new RookBlack(Cell.H8);
        PawnBlack pawn1 = new PawnBlack(Cell.H7);
        logic.add(rook);
        logic.add(pawn1);
        Cell source = rook.position();
        Cell dest = Cell.H7;
        rook.way(source, dest);
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


    @Test
    public void ifWayOfQueenBlackIsBusyThenException() {
        Logic logic = new Logic();
        QueenBlack queen = new QueenBlack(Cell.D8);
        PawnBlack pawn1 = new PawnBlack(Cell.F6);
        PawnBlack pawn2 = new PawnBlack(Cell.A7);
        PawnBlack pawn3 = new PawnBlack(Cell.B7);
        PawnBlack pawn4 = new PawnBlack(Cell.D7);
        PawnBlack pawn5 = new PawnBlack(Cell.E7);
        PawnBlack pawn6 = new PawnBlack(Cell.F7);
        PawnBlack pawn7 = new PawnBlack(Cell.G7);
        PawnBlack pawn8 = new PawnBlack(Cell.H7);
        PawnBlack pawn9 = new PawnBlack(Cell.A8);
        PawnBlack pawn10 = new PawnBlack(Cell.B8);
        PawnBlack pawn12 = new PawnBlack(Cell.E8);
        PawnBlack pawn13 = new PawnBlack(Cell.F8);
        PawnBlack pawn14 = new PawnBlack(Cell.G8);
        PawnBlack pawn15 = new PawnBlack(Cell.H8);
        logic.add(queen);
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
        logic.add(pawn12);
        logic.add(pawn13);
        logic.add(pawn14);
        logic.add(pawn15);
        Cell source = queen.position();
        Cell dest = Cell.F6;
        queen.way(source, dest);
        logic.move(source, dest);
        assertThat(this.mem.toString(), is("Busy way!\r\n"));
    }

    @Test
    public void ifWayOfKingBlackIsBusyThenException() {
        Logic logic = new Logic();
        KingBlack king = new KingBlack(Cell.E8);
        PawnBlack pawn1 = new PawnBlack(Cell.E7);
        logic.add(king);
        logic.add(pawn1);
        Cell source = king.position();
        Cell dest = Cell.E7;
        king.way(source, dest);
        logic.move(source, dest);
        assertThat(this.mem.toString(), is("Busy way!\r\n"));
    }


    @Test
    public void ifWayOfKnightBlackIsBusyThenException() {
        Logic logic = new Logic();
        KnightBlack knight = new KnightBlack(Cell.B8);
        PawnBlack pawn1 = new PawnBlack(Cell.C6);
        logic.add(knight);
        logic.add(pawn1);
        Cell source = knight.position();
        Cell dest = Cell.C6;
        knight.way(source, dest);
        logic.move(source, dest);
        assertThat(this.mem.toString(), is("Busy way!\r\n"));
    }

    @Test
    public void ifWayOfPawnWhiteIsBusyThenException() {
        Logic logic = new Logic();
        PawnWhite pawn = new PawnWhite(Cell.A2);
        PawnWhite pawn2 = new PawnWhite(Cell.A3);
        logic.add(pawn);
        logic.add(pawn2);
        Cell source = pawn.position();
        Cell dest = Cell.A3;
        pawn.way(source, dest);
        logic.move(source, dest);
        assertThat(this.mem.toString(), is("Busy way!\r\n"));
    }

    @Test
    public void ifWayOfWhiteBlackIsBusyThenException() {
        Logic logic = new Logic();
        BishopWhite bishop = new BishopWhite(Cell.C1);
        PawnWhite pawn1 = new PawnWhite(Cell.A2);
        PawnWhite pawn2 = new PawnWhite(Cell.B2);
        PawnWhite pawn3 = new PawnWhite(Cell.C2);
        PawnWhite pawn4 = new PawnWhite(Cell.E2);
        PawnWhite pawn5 = new PawnWhite(Cell.F2);
        PawnWhite pawn6 = new PawnWhite(Cell.G2);
        PawnWhite pawn7 = new PawnWhite(Cell.H2);
        PawnWhite pawn8 = new PawnWhite(Cell.A1);
        PawnWhite pawn9 = new PawnWhite(Cell.B1);
        PawnWhite pawn10 = new PawnWhite(Cell.D1);
        PawnWhite pawn11 = new PawnWhite(Cell.E1);
        PawnWhite pawn12 = new PawnWhite(Cell.F1);
        PawnWhite pawn13 = new PawnWhite(Cell.G1);
        PawnWhite pawn14 = new PawnWhite(Cell.H1);
        PawnBlack pawn15 = new PawnBlack(Cell.A3);
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
        Cell dest = Cell.A3;
        bishop.way(source, dest);
        logic.move(source, dest);
        assertThat(this.mem.toString(), is("Busy way!\r\n"));
    }

    @Test
    public void ifWayOfRookWhiteIsBusyThenException() {
        Logic logic = new Logic();
        RookWhite rook = new RookWhite(Cell.A1);
        PawnBlack pawn1 = new PawnBlack(Cell.A2);
        logic.add(rook);
        logic.add(pawn1);
        Cell source = rook.position();
        Cell dest = Cell.A2;
        rook.way(source, dest);
        logic.move(source, dest);
        assertThat(this.mem.toString(), is("Busy way!\r\n"));
    }

    @Test
    public void ifWayOfQueenWhiteIsBusyThenException() {
        Logic logic = new Logic();
        QueenWhite queen = new QueenWhite(Cell.D1);
        PawnWhite pawn1 = new PawnWhite(Cell.A2);
        PawnWhite pawn2 = new PawnWhite(Cell.B2);
        PawnWhite pawn3 = new PawnWhite(Cell.C2);
        PawnWhite pawn4 = new PawnWhite(Cell.E2);
        PawnWhite pawn5 = new PawnWhite(Cell.F2);
        PawnWhite pawn6 = new PawnWhite(Cell.G2);
        PawnWhite pawn7 = new PawnWhite(Cell.H2);
        PawnWhite pawn8 = new PawnWhite(Cell.A1);
        PawnWhite pawn9 = new PawnWhite(Cell.B1);
        PawnWhite pawn10 = new PawnWhite(Cell.D1);
        PawnWhite pawn11 = new PawnWhite(Cell.E1);
        PawnWhite pawn12 = new PawnWhite(Cell.F1);
        PawnWhite pawn13 = new PawnWhite(Cell.G1);
        PawnWhite pawn14 = new PawnWhite(Cell.H1);
        PawnBlack pawn15 = new PawnBlack(Cell.D3);
        PawnBlack pawn16 = new PawnBlack(Cell.D2);
        logic.add(queen);
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
        logic.add(pawn16);
        Cell source = queen.position();
        Cell dest = Cell.D3;
        queen.way(source, dest);
        logic.move(source, dest);
        assertThat(this.mem.toString(), is("Busy way!\r\n"));
    }

    @Test
    public void ifWayOfKingWhiteIsBusyThenException() {
        Logic logic = new Logic();
        KingWhite king = new KingWhite(Cell.E1);
        PawnBlack pawn1 = new PawnBlack(Cell.D1);
        logic.add(king);
        logic.add(pawn1);
        Cell source = king.position();
        Cell dest = Cell.D1;
        king.way(source, dest);
        logic.move(source, dest);
        assertThat(this.mem.toString(), is("Busy way!\r\n"));
    }

    @Test
    public void ifWayOfKnightWhiteIsBusyThenException() {
        Logic logic = new Logic();
        KnightWhite knight = new KnightWhite(Cell.B1);
        PawnBlack pawn1 = new PawnBlack(Cell.D2);
        logic.add(knight);
        logic.add(pawn1);
        Cell source = knight.position();
        Cell dest = Cell.D2;
        knight.way(source, dest);
        logic.move(source, dest);
        assertThat(this.mem.toString(), is("Busy way!\r\n"));
    }
}