package main.java.projectmanagers.logic;

import org.junit.Before;
import org.junit.Test;

import static main.java.projectmanagers.trackers.PlayerTracking.BLUE_PLAYER;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MillConditionsTest {
    private Board testBoard = new Board();

    @Before
    public void setUp() {
        Board testBoard = new Board();
        testBoard.startingBoard();
    }

    @Test
    public void millsCorrect() {
        Board.placePiece(BLUE_PLAYER, 0, 0);
        Board.placePiece(BLUE_PLAYER, 0, 3);
        Board.placePiece(BLUE_PLAYER, 0, 6);

        assertTrue(Board.isPositionMilled(0, 3));
    }

    @Test
    public void millsCorrectOnRemove() {
        Board.placePiece(BLUE_PLAYER, 0, 0);
        Board.placePiece(BLUE_PLAYER, 0, 3);
        Board.placePiece(BLUE_PLAYER, 0, 6);

        Board.remove(0, 6);
        assertFalse(Board.isPositionMilled(0, 3));
    }
}
