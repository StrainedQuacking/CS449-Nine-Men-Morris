package main.java.projectmanagers.logic;

import javafx.util.Pair;
import main.java.projectmanagers.trackers.PlayerTracking.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static main.java.projectmanagers.trackers.PlayerTracking.BLUE_PLAYER;

public class AI {


    static public Pair<Integer, Integer> AIPlacePiece() {


        if(GameStatuses.turnCounter == 1)
            return new Pair<>(0, 0);
        else if (GameStatuses.turnCounter == 2) {
            if (Board.position(0, 0) == GameStatuses.ColorStatus.RED && Board.position(6, 6) == GameStatuses.ColorStatus.EMPTY)
                return new Pair<>(6, 6);
            else if (Board.position(6, 0) == GameStatuses.ColorStatus.RED && Board.position(0, 6) == GameStatuses.ColorStatus.EMPTY)
                return new Pair<>(0, 6);
            else if (Board.position(6, 6) == GameStatuses.ColorStatus.RED && Board.position(0, 0) == GameStatuses.ColorStatus.EMPTY)
                return new Pair<>(0, 0);
            else if (Board.position(0, 6) == GameStatuses.ColorStatus.RED && Board.position(6, 0) == GameStatuses.ColorStatus.EMPTY)
                return new Pair<>(6, 0);
        }


        List<Pair<Integer, Integer>> myPieces = new ArrayList<>();

//        for (int i = 0; i < 7; i++) {
//            for (int j = 0; i < 7; j++) {
//                if (Board.boardArray.get(i).get(j).getStatus() == GameStatuses.ColorStatus.BLUE)
//                    myPieces.add(new Pair<>(i, j));
//            }
//        }


        //else if I have a potential mill, add piece to the free space

        //else if opponent has a potential mill, add piece to the free space

        //else if I have the potential to set up  a mill, place adjacent to placed piece
        /*
        for (int i = 0; i < myPieces.size(); i++) {
            Pair<Integer, Integer> temp = myPieces.get(i);
            List<Pair<Integer, Integer>> adjacent = Board.adjacentPieces(temp.getKey(), temp.getValue());

            for (int j = 0; j < adjacent.size(); j++) {

                if (Board.boardArray.get(adjacent.get(j).getKey()).get(adjacent.get(j).getValue()).getStatus() == GameStatuses.ColorStatus.EMPTY) {

                    Pair<Integer, Integer> temp2 = adjacent.get(j);
                    List<Pair<Integer, Integer>> adjacent2 = Board.adjacentPieces(temp2.getKey(), temp2.getValue());

                    if (Board.boardArray.get(adjacent2.get(j).getKey()).get(adjacent2.get(j).getValue()).getStatus() == GameStatuses.ColorStatus.EMPTY)
                        return adjacent.get(i);
                }
            }
        }
        */

        //if none are applicable, place a random piece
        return randomFree("place").get(0);
    }

    static public List<Pair<Integer, Integer>> AIMovePiece() {

        List<Pair<Integer, Integer>> swapPieces = new ArrayList<>();


        //if I have potential mill, move piece to make the mill

        //else if my opponent has a potential mill, move piece to the free space

        //else if I am one move away from setting up a mill, move piece to the free space
        List<Pair<Integer, Integer>> myPieces = new ArrayList<>();
        /*
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (Board.boardArray.get(i).get(j).getStatus() == GameStatuses.ColorStatus.BLUE)
                    myPieces.add(new Pair<>(i, j));
            }
        }

        for (int i = 0; i < myPieces.size(); i++) {
            Pair<Integer, Integer> temp = myPieces.get(i);
            List<Pair<Integer, Integer>> adjacent = Board.adjacentPieces(temp.getKey(), temp.getValue());

            for (int j = 0; j < adjacent.size(); j++) {

                if (Board.boardArray.get(adjacent.get(j).getKey()).get(adjacent.get(j).getValue()).getStatus() == GameStatuses.ColorStatus.EMPTY) {

                    Pair<Integer, Integer> temp2 = adjacent.get(j);
                    List<Pair<Integer, Integer>> adjacent2 = Board.adjacentPieces(temp2.getKey(), temp2.getValue());

                    if (Board.boardArray.get(adjacent2.get(j).getKey()).get(adjacent2.get(j).getValue()).getStatus() == GameStatuses.ColorStatus.EMPTY) {
                        swapPieces.add(temp);
                        swapPieces.add(adjacent.get(i));
                        return swapPieces;
                    }
                }
            }
        }
        */

        //if none are applicable, move random piece
            return randomFree("move");
    }

    static public Pair<Integer, Integer> AIRemovePiece() {

        //If my opponent has a potential mill, remove that piece

        //MAYBE: else if my opponent is two moves away from a potential mill, remove that piece

        //else, remove a random piece of my opponents
        return randomFree("remove").get(0);

    }

    static private List<Pair<Integer, Integer>> randomFree(String mode) {

        Random random = new Random();

        Boolean hasAdjacentFree = false;

        Integer randomX = random.nextInt(6);
        Integer randomY = random.nextInt(6);

        List<Pair<Integer, Integer>> adjacent;
        List<Pair<Integer, Integer>> pieces = new ArrayList<>();


        if (mode.equals("place")) {
            while (true) {

                if (Board.position(randomX, randomY) == GameStatuses.ColorStatus.EMPTY) {
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
                if (Board.position(randomX, randomY) == GameStatuses.ColorStatus.RED) {
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

                adjacent = Board.adjacentPieces(randomX, randomY);

                if (BLUE_PLAYER.getPieces() > 3 && Board.position(randomX, randomY) == GameStatuses.ColorStatus.BLUE) {
                       for (int i = 0; i < adjacent.size(); i++) {
                           if (Board.position(adjacent.get(i).getKey(), adjacent.get(i).getValue()) == GameStatuses.ColorStatus.EMPTY)
                               hasAdjacentFree = true;
                       }
                   }
                else if (BLUE_PLAYER.getPieces() <= 3 && Board.position(randomX, randomY) == GameStatuses.ColorStatus.BLUE)
                    hasAdjacentFree = true; //TODO:fix scoping

                if (Board.position(randomX, randomY) == GameStatuses.ColorStatus.BLUE && hasAdjacentFree) {
                    pieces.add(new Pair<>(randomX, randomY));
                    myPiece = true;
                }
                else {
                    randomX = random.nextInt(6);
                    randomY = random.nextInt(6);
                }
            }

            if (BLUE_PLAYER.getPieces() <= 3) {
                while(true) {

                    randomX = random.nextInt(6);
                    randomY = random.nextInt(6);

                    if (Board.position(randomX, randomY) == GameStatuses.ColorStatus.EMPTY) {
                        pieces.add(new Pair<>(randomX, randomY));
                        return pieces;
                    }
                }
            }
            else {

                adjacent = Board.adjacentPieces(randomX, randomY);

                for (int i = 0; i < adjacent.size(); i++) {

                    Pair temp = adjacent.get(i);

                    if (Board.position((Integer) temp.getKey(),(Integer) temp.getValue()) == GameStatuses.ColorStatus.EMPTY) {
                        pieces.add(temp);
                        return pieces;
                    }
                }
            }
        }

        return null;
    }

}
