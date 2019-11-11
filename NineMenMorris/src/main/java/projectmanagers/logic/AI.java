package main.java.projectmanagers.logic;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class AI {


    static public Pair<Integer, Integer> AIPlacePiece() {


        if (GameStatuses.turnCounter <= 2) {
            if (Board.boardArray.get(0).get(0).getStatus() == GameStatuses.ColorStatus.RED && Board.boardArray.get(6).get(6).getStatus() == GameStatuses.ColorStatus.EMPTY)
                return new Pair<>(6, 6);
            else if (Board.boardArray.get(6).get(0).getStatus() == GameStatuses.ColorStatus.RED && Board.boardArray.get(0).get(6).getStatus() == GameStatuses.ColorStatus.EMPTY)
                return new Pair<>(0, 6);
            else if (Board.boardArray.get(6).get(6).getStatus() == GameStatuses.ColorStatus.RED && Board.boardArray.get(0).get(0).getStatus() == GameStatuses.ColorStatus.EMPTY)
                return new Pair<>(0, 0);
            else if (Board.boardArray.get(0).get(6).getStatus() == GameStatuses.ColorStatus.RED && Board.boardArray.get(6).get(0).getStatus() == GameStatuses.ColorStatus.EMPTY)
                return new Pair<>(6, 0);
        }

        //else if I have a potential mill, add piece to the free space

        //else if opponent has a potential mill, add piece to the free space


        return randomFree("place").get(0);
    }

    static public List<Pair<Integer, Integer>> AIMovePiece() {

        List<Pair<Integer, Integer>> swapPieces = new ArrayList<>();




        return randomFree("move");

    }

    static public Pair<Integer, Integer> AIRemovePiece() {



        return randomFree("remove").get(0);

    }

    static private List<Pair<Integer, Integer>> randomFree(String mode) {

        Random random = new Random();

        List<Pair<Integer, Integer>> pieces = new ArrayList<>();

        Integer randomX = random.nextInt(6);
        Integer randomY = random.nextInt(6);

        if (mode.equals("place")) {
            while (true) {
                if (Board.boardArray.get(randomX).get(randomY).getStatus() == GameStatuses.ColorStatus.EMPTY) {
                    pieces.add(new Pair<>(randomX, randomY));
                    return pieces;
                }
                else {
                    randomX = random.nextInt(6);
                    randomY = random.nextInt(6);
                }
            }
        }
        else if (mode.equals("remove")) {
            while (true) {
                if (Board.boardArray.get(randomX).get(randomY).getStatus() == GameStatuses.ColorStatus.RED) {
                    pieces.add(new Pair<>(randomX, randomY));
                    return pieces;
                }
                else {
                    randomX = random.nextInt(6);
                    randomY = random.nextInt(6);
                }
            }
        }
        else if (mode.equals("move")){
            boolean myPiece = false;
            while (!myPiece) {
                if (Board.boardArray.get(randomX).get(randomY).getStatus() == GameStatuses.ColorStatus.BLUE) {
                    pieces.add(new Pair<>(randomX, randomY));
                    myPiece = true;
                }
                else {
                    randomX = random.nextInt(6);
                    randomY = random.nextInt(6);
                }
            }

            List<Pair<Integer, Integer>> adjacent = Board.adjacentPieces(randomX, randomY);

            for (int i = 0; i < adjacent.size(); i++) {

                Pair temp = adjacent.get(i);

                //if (Board.boardArray.get(adjacent.get(0)))

            }

        }

        return null;

    }

}
