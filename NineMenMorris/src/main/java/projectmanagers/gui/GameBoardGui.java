package main.java.projectmanagers.gui;

import javax.swing.*;
import java.awt.*;

public class GameBoardGui extends JFrame {
    private JPanel masterPanel;

    private int MAX_HEIGHT = 600;
    private int MAX_WIDTH = 800;

    public GameBoardGui () {
        super();
        masterPanel = new JPanel();
        buildBoard();
        start();
    }

    public void buildBoard() {
        masterPanel.setBackground(new Color(153,133,97));
        masterPanel.setLayout(new BorderLayout());
        masterPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        masterPanel.setPreferredSize(new Dimension(MAX_WIDTH, MAX_HEIGHT));
        addPanels();
    }
    public void addPanels() {
        this.add(masterPanel);
    }
    public static void start() {
        JFrame frame = new JFrame("CS 449 Project");
        frame.setResizable(false);
        frame.setContentPane(new GameBoardGui().masterPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }
}
