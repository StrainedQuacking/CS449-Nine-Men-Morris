package main.java.projectmanagers.logic;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static main.java.projectmanagers.logic.GameStatuses.ColorStatus;
import static main.java.projectmanagers.logic.GameStatuses.ColorStatus.EMPTY;
import static main.java.projectmanagers.logic.GameStatuses.ColorStatus.INVALID;
import static main.java.projectmanagers.trackers.PlayerTracking.PLAYER_LOOKUP;

public class Board {

    static private List<List<Position>> boardArray = new ArrayList<>();
    static public ColorStatus[][] boardMills = new ColorStatus[16][3];

    public Board() {
        startingBoard();
    }

    static void startingBoard() {

        for (int i = 0; i < 7; i++){
            boardArray.add(new ArrayList<>());
            for (int j = 0; j < 7; j++){
                boardArray.get(i).add(new Position());
            }
        }
        // xpos, ypos
        boardArray.get(0).get(0).setStatus(EMPTY);
        boardArray.get(0).get(3).setStatus(EMPTY);
        boardArray.get(0).get(6).setStatus(EMPTY);

        boardArray.get(1).get(1).setStatus(EMPTY);
        boardArray.get(1).get(3).setStatus(EMPTY);
        boardArray.get(1).get(5).setStatus(EMPTY);

        boardArray.get(2).get(2).setStatus(EMPTY);
        boardArray.get(2).get(3).setStatus(EMPTY);
        boardArray.get(2).get(4).setStatus(EMPTY);

        boardArray.get(3).get(0).setStatus(EMPTY);
        boardArray.get(3).get(1).setStatus(EMPTY);
        boardArray.get(3).get(2).setStatus(EMPTY);
        boardArray.get(3).get(4).setStatus(EMPTY);
        boardArray.get(3).get(5).setStatus(EMPTY);
        boardArray.get(3).get(6).setStatus(EMPTY);

        boardArray.get(4).get(2).setStatus(EMPTY);
        boardArray.get(4).get(3).setStatus(EMPTY);
        boardArray.get(4).get(4).setStatus(EMPTY);

        boardArray.get(5).get(1).setStatus(EMPTY);
        boardArray.get(5).get(3).setStatus(EMPTY);
        boardArray.get(5).get(5).setStatus(EMPTY);

        boardArray.get(6).get(0).setStatus(EMPTY);
        boardArray.get(6).get(3).setStatus(EMPTY);
        boardArray.get(6).get(6).setStatus(EMPTY);

    }

    static public boolean placePiece(Player player, int xpos, int ypos) {
        if ((Board.boardArray.get(xpos).get(ypos).getStatus() == EMPTY) && (Board.boardArray.get(xpos).get(ypos).getStatus() != INVALID)) {
            Board.boardArray.get(xpos).get(ypos).setStatus(player.getColor());
            player.incrementPieces();
            determineMills();
            return true;
        } else {
            return false;
        }
    }

    static public boolean remove(int xpos, int ypos) {
        if (boardArray.get(xpos).get(ypos).getStatus() != EMPTY && boardArray.get(xpos).get(ypos).getStatus() != INVALID) {
            PLAYER_LOOKUP.get(boardArray.get(xpos).get(ypos).getStatus()).decrementPieces();
            boardArray.get(xpos).get(ypos).setStatus(EMPTY);
            return true;
        } else {
            return false;
        }
    }

    static public ColorStatus position(int xpos, int ypos) {
        return boardArray.get(xpos).get(ypos).getStatus();
    }

    static public boolean isPositionMilled(int xpos, int ypos) {
        return boardArray.get(xpos).get(ypos).isMilled();
    }

    static private void determineMills() {
        //TODO: Sprint 2
    }

    static private void millAllocation() {
        // TODO: Sprint 2


        /*
        //will always be EMPTY enum
        boardMills[0][0] = boardArray[0][0];
        boardMills[0][1] = boardArray[0][3];
        boardMills[0][2] = boardArray[0][6];

        boardMills[1][0] = boardArray[1][1];
        boardMills[1][1] = boardArray[1][3];
        boardMills[1][2] = boardArray[1][5];

        boardMills[2][0] = boardArray[2][2];
        boardMills[2][1] = boardArray[2][3];
        boardMills[2][2] = boardArray[2][4];

        boardMills[3][0] = boardArray[3][0];
        boardMills[3][1] = boardArray[3][1];
        boardMills[3][2] = boardArray[3][2];

        boardMills[4][0] = boardArray[3][4];
        boardMills[4][1] = boardArray[3][5];
        boardMills[4][2] = boardArray[3][6];

        boardMills[5][0] = boardArray[4][2];
        boardMills[5][1] = boardArray[4][3];
        boardMills[5][2] = boardArray[4][4];

        boardMills[6][0] = boardArray[5][1];
        boardMills[6][1] = boardArray[5][3];
        boardMills[6][2] = boardArray[5][5];

        boardMills[7][0] = boardArray[6][0];
        boardMills[7][1] = boardArray[6][3];
        boardMills[7][2] = boardArray[6][6];

        boardMills[8][0] = ;
        boardMills[8][1] = ;
        boardMills[8][2] = ;

        boardMills[9][0] = ;
        boardMills[9][1] = ;
        boardMills[9][2] = ;

        boardMills[10][0] = ;
        boardMills[10][1] = ;
        boardMills[10][2] = ;

        boardMills[11][0] = ;
        boardMills[11][1] = ;
        boardMills[11][2] = ;

        boardMills[12][0] = ;
        boardMills[12][1] = ;
        boardMills[12][2] = ;

        boardMills[13][0] = ;
        boardMills[13][1] = ;
        boardMills[13][2] = ;

        boardMills[14][0] = ;
        boardMills[14][1] = ;
        boardMills[14][2] = ;

        boardMills[15][0] = ;
        boardMills[15][1] = ;
        boardMills[15][2] = ;
        */

    }

    static public List<Pair<Integer, Integer>> adjacentPieces(int xpos, int ypos) {

        List<Pair<Integer, Integer>> adjacentPieces = new ArrayList<>();

        switch (ypos) {
            case 0:
                if (xpos == 0) {
                    adjacentPieces.add(new Pair<>(3, 0));
                    adjacentPieces.add(new Pair<>(0, 3));
                }
                else if (xpos == 3) {
                    adjacentPieces.add(new Pair<>(0, 0));
                    adjacentPieces.add(new Pair<>(6, 0));
                    adjacentPieces.add(new Pair<>(3, 1));
                }
                else if (xpos == 6) {
                    adjacentPieces.add(new Pair<>(3, 0));
                    adjacentPieces.add(new Pair<>(6, 3));
                }
                break;
            case 1:
                if (xpos == 1) {
                    adjacentPieces.add(new Pair<>(1, 3));
                    adjacentPieces.add(new Pair<>(3, 1));
                }
                else if (xpos == 3) {
                    adjacentPieces.add(new Pair<>(3, 0));
                    adjacentPieces.add(new Pair<>(1, 1));
                    adjacentPieces.add(new Pair<>(5, 1));
                    adjacentPieces.add(new Pair<>(3, 2));
                }
                else if (xpos == 5) {
                    adjacentPieces.add(new Pair<>(3, 1));
                    adjacentPieces.add(new Pair<>(5, 3));
                }
                break;
            case 2:
                if (xpos == 2) {
                    adjacentPieces.add(new Pair<>(2, 3));
                    adjacentPieces.add(new Pair<>(3, 2));
                }
                else if (xpos == 3) {
                    adjacentPieces.add(new Pair<>(2, 2));
                    adjacentPieces.add(new Pair<>(3, 1));
                    adjacentPieces.add(new Pair<>(4, 2));
                }
                else if (xpos == 4) {
                    adjacentPieces.add(new Pair<>(3, 2));
                    adjacentPieces.add(new Pair<>(4, 3));
                }
                break;
            case 3:
                if (xpos == 0) {
                    adjacentPieces.add(new Pair<>(0, 0));
                    adjacentPieces.add(new Pair<>(0, 6));
                    adjacentPieces.add(new Pair<>(1, 3));
                }
                else if (xpos == 1) {
                    adjacentPieces.add(new Pair<>(0, 3));
                    adjacentPieces.add(new Pair<>(1, 1));
                    adjacentPieces.add(new Pair<>(1, 5));
                    adjacentPieces.add(new Pair<>(2, 3));
                }
                else if (xpos == 2) {
                    adjacentPieces.add(new Pair<>(1, 3));
                    adjacentPieces.add(new Pair<>(2, 2));
                    adjacentPieces.add(new Pair<>(2, 4));
                }
                else if (xpos == 4) {
                    adjacentPieces.add(new Pair<>(5, 3));
                    adjacentPieces.add(new Pair<>(4, 2));
                    adjacentPieces.add(new Pair<>(4, 4));
                }
                else if (xpos == 5) {
                    adjacentPieces.add(new Pair<>(4, 3));
                    adjacentPieces.add(new Pair<>(5, 1));
                    adjacentPieces.add(new Pair<>(5, 5));
                    adjacentPieces.add(new Pair<>(6, 3));
                }
                else if (xpos == 6) {
                    adjacentPieces.add(new Pair<>(5, 3));
                    adjacentPieces.add(new Pair<>(6, 0));
                    adjacentPieces.add(new Pair<>(6, 6));
                }
                break;
            case 4:
                if (xpos == 2) {
                    adjacentPieces.add(new Pair<>(2, 3));
                    adjacentPieces.add(new Pair<>(3, 4));
                }
                else if (xpos == 3) {
                    adjacentPieces.add(new Pair<>(2, 4));
                    adjacentPieces.add(new Pair<>(3, 5));
                    adjacentPieces.add(new Pair<>(4, 4));
                }
                else if (xpos == 4) {
                    adjacentPieces.add(new Pair<>(3, 4));
                    adjacentPieces.add(new Pair<>(4, 3));
                }
                break;
            case 5:
                if (xpos == 1) {
                    adjacentPieces.add(new Pair<>(1, 3));
                    adjacentPieces.add(new Pair<>(3, 5));
                }
                else if (xpos == 3) {
                    adjacentPieces.add(new Pair<>(3, 6));
                    adjacentPieces.add(new Pair<>(1, 5));
                    adjacentPieces.add(new Pair<>(5, 5));
                    adjacentPieces.add(new Pair<>(3, 4));
                }
                else if (xpos == 5) {
                    adjacentPieces.add(new Pair<>(3, 5));
                    adjacentPieces.add(new Pair<>(5, 3));
                }
                break;
            case 6:
                if (xpos == 0) {
                    adjacentPieces.add(new Pair<>(3, 6));
                    adjacentPieces.add(new Pair<>(0, 3));
                }
                else if (xpos == 3) {
                    adjacentPieces.add(new Pair<>(0, 6));
                    adjacentPieces.add(new Pair<>(6, 6));
                    adjacentPieces.add(new Pair<>(3, 5));
                }
                else if (xpos == 6) {
                    adjacentPieces.add(new Pair<>(3, 6));
                    adjacentPieces.add(new Pair<>(6, 3));
                }
                break;
            default:
                adjacentPieces = Collections.emptyList();
        }
        return adjacentPieces;
    }
}
