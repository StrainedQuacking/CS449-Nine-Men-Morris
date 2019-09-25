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
                if(Board.boardArray[i][j] == GameStatuses.ColorStatus.INVALID){
                    gbc.gridx = i; gbc.gridy = j;
                    if ((j == 0 || j == 1 || j == 5 || j == 6) && (i != 0 && i != 6)) {
                        gbc.fill = GridBagConstraints.HORIZONTAL;
                        add(new BoardLines(2), gbc);
                    }
                    else if (j != 3 && i != 3){
                        gbc.fill = GridBagConstraints.VERTICAL;
                        add(new BoardLines(3), gbc);
                    }
                }
                else {
                    gbc.gridx = i; gbc.gridy = j;
                    gbc.fill = GridBagConstraints.HORIZONTAL;
                    if (((i == 1 || i == 5) && j == 3) || (i == 3 && j != 3))
                        add(new BoardLines(2), gbc);
                    else if ( (i == 0 || i == 1 || (i == 4 && j == 3) || (i == 2 && j != 3)))
                        add(new BoardLines(1), gbc);
                    else if ( (i == 5 || i == 6 || (i == 2 && j == 3) || (i == 4 && j != 3)))
                        add(new BoardLines(5), gbc);
                    gbc.fill = GridBagConstraints.VERTICAL;
                    if ((j == 1 || j == 2) && i != 3)
                        add(new BoardLines(0), gbc);
                    else if (( j == 5 || j == 4) && i != 3)
                        add(new BoardLines(6), gbc);
                    else if ((j == 5 || j == 1) && i == 3)
                        add(new BoardLines(3), gbc);
                    else if (j == 4 && i == 3)
                        add(new BoardLines(0), gbc);
                    else if (j == 2 && i == 3)
                        add(new BoardLines(6), gbc);
                    add(new BoardLines(j), gbc);
                }
            }
        }
    }
}
