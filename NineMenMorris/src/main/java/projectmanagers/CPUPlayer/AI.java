package main.java.projectmanagers.CPUPlayer;

import javafx.util.Pair;
import main.java.projectmanagers.logic.Board;
import main.java.projectmanagers.logic.GameStatuses;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static main.java.projectmanagers.logic.GameStatuses.ColorStatus.*;

import static main.java.projectmanagers.logic.GameStatuses.NO_PLACE;
import static main.java.projectmanagers.trackers.PlayerTracking.BLUE_PLAYER;
import static main.java.projectmanagers.trackers.PlayerTracking.RED_PLAYER;
import static main.java.projectmanagers.trackers.PlayerTracking.*;

public class AI {

    static public GameStatuses.GameDifficulty gameDiff;

    static Random rand = new Random();
    static int randDiff;

    static public Pair<Integer, Integer> AIPlacePiece() {

        randDiff = rand.nextInt(2);
        Pair<Integer, Integer> myPiece;

        if ((gameDiff == GameStatuses.GameDifficulty.MEDIUM && randDiff == 1) || gameDiff == GameStatuses.GameDifficulty.HARD) {
            if (GameStatuses.turnCounter == 1)
                return new Pair<>(0, 0);
            else if (GameStatuses.turnCounter == 2) {
                if (Board.position(0, 0) == RED && Board.position(6, 6) == EMPTY)
                    return new Pair<>(6, 6);
                else if (Board.position(6, 0) == RED && Board.position(0, 6) == EMPTY)
                    return new Pair<>(0, 6);
                else if (Board.position(6, 6) == RED && Board.position(0, 0) == EMPTY)
                    return new Pair<>(0, 0);
                else if (Board.position(0, 6) == RED && Board.position(6, 0) == EMPTY)
                    return new Pair<>(6, 0);
            }

            myPiece = DetermineMove.placementMills(BLUE);
            if (myPiece.equals(NO_PLACE)) {
                myPiece = DetermineMove.placementMills(RED);
            }
            return myPiece;

        }
            // Basic mill placing or Random piece
            myPiece = DetermineMove.placementMills(BLUE);
            if (myPiece.equals(NO_PLACE)) {
                return getRandom(EMPTY);
            }
            return myPiece;


    }

    static public Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> AIMovePiece() {

        randDiff = rand.nextInt(2);

        if ((gameDiff == GameStatuses.GameDifficulty.MEDIUM && randDiff == 1) || gameDiff == GameStatuses.GameDifficulty.HARD) {
            Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> currNew = DetermineMove.movementMills(BLUE);
            if (!(currNew.getKey().equals(NO_PLACE))) {
                return currNew;
            }
        }

        Pair<Integer, Integer> currentPosition = null;
        Pair<Integer, Integer> newPosition = null;
        List<Pair<Integer, Integer>> adjacent;

        boolean hasEmpty = false;
        // Get Current Piece
        while (!hasEmpty) {
            currentPosition = getRandom(BLUE);
            adjacent = Board.adjacentPieces(currentPosition.getKey(), currentPosition.getValue());

            if (BLUE_PLAYER.getPieces() > 3) {
                for (Pair<Integer, Integer> pair : adjacent) {
                    if (Board.position(pair).equals(EMPTY)) {
                        hasEmpty = true;
                    }
                }
            } else if (BLUE_PLAYER.getPieces() <= 3) {
                hasEmpty = true;
            }

        }

        // Get new space
        if (BLUE_PLAYER.getPieces() <= 3) {
            newPosition = getRandom(EMPTY);
        } else {
            adjacent = Board.adjacentPieces(currentPosition.getKey(), currentPosition.getValue());

            for (Pair<Integer, Integer> pair : adjacent) {
                if (Board.position(pair).equals(EMPTY)) {
                    newPosition = pair;
                    break;
                }
            }
        }


        return new Pair<>(currentPosition, newPosition);
    }

    static public Pair<Integer, Integer> AIRemovePiece() {

        randDiff = rand.nextInt(2);

        Pair<Integer, Integer> removal =  NO_PLACE;

        if ((gameDiff == GameStatuses.GameDifficulty.MEDIUM && randDiff == 1) || gameDiff == GameStatuses.GameDifficulty.HARD) {

            List<Pair<Integer, Integer>> enemyPieces = RED_PLAYER.getPlacedPieces();
            for (Pair<Integer, Integer> piece : enemyPieces) {
                if ((Board.isPositionCloseToMilled(piece)).getKey().equals(RED)) {
                    removal = piece;
                }
            }
        }

        if (RED_PLAYER.allPiecesMilled()){
            removal = getRandom(RED);
        } else {
            for (Pair<Integer, Integer> piece : RED_PLAYER.getPlacedPieces()) {
                if (!Board.isPositionMilled(piece.getKey(), piece.getValue())){
                    removal = piece;
                }
            }
        }
        return removal;
    }

    static public Pair<Integer, Integer> getRandom(GameStatuses.ColorStatus color) {
        Random rand = new Random();
        List<Pair<Integer, Integer>> piecesList = new ArrayList<>();
        if (color.equals(EMPTY)) {
            piecesList = Board.getEmptyPieces();
        } else {
            piecesList = PLAYER_LOOKUP.get(color).getPlacedPieces();
        }
        return piecesList.get(rand.nextInt(piecesList.size()));
    }

}
