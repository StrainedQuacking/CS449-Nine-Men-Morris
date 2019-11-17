package main.java.projectmanagers.CPUPlayer;

import javafx.util.Pair;
import main.java.projectmanagers.logic.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static main.java.projectmanagers.logic.GameStatuses.ColorStatus;

public class DetermineMove {
    static Pair<Integer, Integer> placementMills(ColorStatus color) {
        List<Pair<Integer, Integer>> positions = Board.getEmptyPieces();
        if (positions.isEmpty()) {
            return new Pair<>(-1, -1);
        }

        List<Pair<Integer, Integer>> closeToMill = new ArrayList<>();

        for (Pair<Integer, Integer> position : positions) {
            if ((Board.isPositionCloseToMilled(position.getKey(), position.getValue())).equals(color)) {
                closeToMill.add(position);
            }
        }

        if (closeToMill.isEmpty()){
            return new Pair<>(-1, -1);
        } else {
            Random rand = new Random();
            return closeToMill.get(rand.nextInt(closeToMill.size()));
        }
    }
}
