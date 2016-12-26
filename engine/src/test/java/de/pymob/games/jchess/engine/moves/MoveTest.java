package de.pymob.games.jchess.engine.moves;

import de.pymob.games.jchess.engine.Position;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static de.pymob.games.jchess.engine.moves.MoveDirection.*;
import static java.lang.Integer.valueOf;
import static org.junit.Assert.assertEquals;

public class MoveTest {
    private Move move;

    @Before
    public void beforeEach() {
        this.move = null;
    }

    @Test
    public void testMoveOneNorth() {
        move = new Move(Position.A2, Position.A3);
        checkOne(N);
    }

    @Test
    public void testMoveOneNorthEast() {
        move = new Move(Position.A2, Position.B3);
        checkOne(NE);
    }

    @Test
    public void testMoveOneEast() {
        move = new Move(Position.A2, Position.B2);
        checkOne(E);
    }

    @Test
    public void testMoveOneSouthEast() {
        move = new Move(Position.B2, Position.C1);
        checkOne(SE);
    }

    @Test
    public void testMoveOneSouth() {
        move = new Move(Position.A2, Position.A1);
        checkOne(S);
    }

    @Test
    public void testMoveOneSouthWest() {
        move = new Move(Position.C3, Position.B2);
        checkOne(SW);
    }

    @Test
    public void testMoveOneWest() {
        move = new Move(Position.B2, Position.A2);
        checkOne(W);
    }

    @Test
    public void testMoveOneNorthWest() {
        move = new Move(Position.B2, Position.A3);
        checkOne(NW);
    }

    //TODO checkOne for more than 1 distance

    @Test
    public void testMoveNorthA1A8() {
        move = new Move(Position.A1, Position.A8);
        checkMultiple(7, N);
    }

    @Test
    public void testMoveNorthEastA1H8() {
        move = new Move(Position.A1, Position.H8);
        checkMultiple(7, NE);
    }

    @Test
    public void testMoveEastA1H1() {
        move = new Move(Position.A1, Position.H1);
        checkMultiple(7, E);
    }

    @Test
    public void testMoveSouthEastA8H1() {
        move = new Move(Position.A8, Position.H1);
        checkMultiple(7, SE);
    }

    @Test
    public void testMoveSouthA8A1() {
        move = new Move(Position.A8, Position.A1);
        checkMultiple(7, S);
    }

    @Test
    public void testMoveSouthWestH8A1() {
        move = new Move(Position.H8, Position.A1);
        checkMultiple(7, SW);
    }

    @Test
    public void testMoveWestH1A1() {
        move = new Move(Position.H1, Position.A1);
        checkMultiple(7, W);
    }

    @Test
    public void testMoveNorthWestH1A8() {
        move = new Move(Position.H1, Position.A8);
        checkMultiple(7, NW);
    }

    private void checkMultiple(Integer expectedDistance, MoveDirection expectedMoveDirection) {
        assertEquals(expectedDistance, move.getMoveDistance());
        assertEquals(expectedMoveDirection, move.getMoveDirection());
    }

    private void checkOne(MoveDirection expectedDirection) {
        assertEquals(valueOf(1), move.getMoveDistance());
        assertEquals(expectedDirection, move.getMoveDirection());
    }

}