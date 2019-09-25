package main.java.projectmanagers.gui.panels;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import main.java.projectmanagers.gui.components.BoardLines;
import main.java.projectmanagers.gui.components.BoardPieces;
import main.java.projectmanagers.logic.Board;
import main.java.projectmanagers.logic.GameStatuses;

public class GamePanel extends JPanel {
    private GridBagConstraints gbc;
    public static ArrayList<BoardPieces> boardPieces;

    public GamePanel () {
        super();
        boardPieces = new ArrayList<>(24);
        buildArray();
        buildBoard();
    }
    public void buildBoard () {
        gbc = new GridBagConstraints();
        gbc.weighty = 0.1; gbc.weightx = 0.1;
        setLayout(new GridBagLayout());
        setBackground(new Color(153,133,97));
        drawBoardPieces();
        drawBoardLines();
    }
    public void buildArray (){
        for (int i = 0; i < 24; i++)
            boardPieces.add(new BoardPieces());
    }
    public void drawBoardPieces () {
        int count = 0;
        for (int i = 0; i < 7 ; i ++) {
            for (int j = 0; j < 7; j++) {
                if(Board.boardArray[i][j] == GameStatuses.ColorStatus.EMPTY){
                    gbc.gridx = i; gbc.gridy = j;
                    add(boardPieces.get(count), gbc);
                    count++;
                }
            }
        }
    }
    public void drawBoardLines() {
        for (int i = 0; i < 7 ; i ++) {
            for (int j = 0; j < 7; j++) {
                if(Board.boardArray[i][j] == GameStatuses.ColorStatus.EMPTY){
                    gbc.gridx = i; gbc.gridy = j;
                }
            }
        }
    }
}
