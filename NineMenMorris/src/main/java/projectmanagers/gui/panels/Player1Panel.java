package main.java.projectmanagers.gui.panels;
import main.java.projectmanagers.gui.components.Player1Pieces;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Player1Panel extends JPanel {
    private ArrayList<Player1Pieces> pieces;
    public JLabel player1Txt;
    public static int turns = 9;
    private GridBagConstraints gbc;

    public Player1Panel () {
        pieces = new ArrayList<>(turns);
        gbc = new GridBagConstraints();
        player1Txt = new JLabel("Player 1");
        buildPanel();
    }
    public void buildPanel () {
        gbc.weighty = 0.1;   gbc.gridy = 0;   gbc.gridx = 0;
        setLayout(new GridBagLayout());
        setBackground(new Color(116,101,72));
        setPreferredSize(new Dimension(75,600));
        player1Txt.setHorizontalAlignment(SwingConstants.CENTER);
        add(player1Txt, gbc);
        trackTurns();
    }
    public void trackTurns () {
        for (int i = 0; i < turns; i++) {
            gbc.gridy = i + 1;
            pieces.add(new Player1Pieces());
            add(pieces.get(i), gbc);
        }
    }
    public void decrementTurns () {
        if (turns != 0) {
            turns--;
            remove(pieces.get(turns));
            trackTurns();
            repaint();
        }
    }
}

