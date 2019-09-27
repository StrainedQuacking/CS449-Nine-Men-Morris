package main.java.projectmanagers.gui;
import main.java.projectmanagers.gui.panels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameBoardGui extends JFrame {
    private JPanel masterPanel;
    private GamePanel gamePanel;
    private TitlePanel titlePanel;
    private ButtonPanel buttonPanel;
    private Player1Panel player1Panel;
    private Player2Panel player2Panel;
    private boolean aTurn = true;

    private int MAX_HEIGHT = 600;
    private int MAX_WIDTH = 800;

    public GameBoardGui () {
        super();
        masterPanel = new JPanel();
        gamePanel = new GamePanel();
        titlePanel = new TitlePanel();
        buttonPanel = new ButtonPanel();
        player1Panel = new Player1Panel();
        player2Panel = new Player2Panel();
        buildBoard();
        playPiece();
    }

    public void buildBoard() {
        masterPanel.setBackground(new Color(153,133,97));
        masterPanel.setLayout(new BorderLayout());
        masterPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        masterPanel.setPreferredSize(new Dimension(MAX_WIDTH, MAX_HEIGHT));
        addPanels();
        buttonActions();
    }
    public void addPanels() {
        masterPanel.add(gamePanel, BorderLayout.CENTER);
        masterPanel.add(titlePanel, BorderLayout.NORTH);
        masterPanel.add(buttonPanel, BorderLayout.SOUTH);
        masterPanel.add(player1Panel, BorderLayout.WEST);
        masterPanel.add(player2Panel, BorderLayout.EAST);
        this.add(masterPanel);
    }
    public void buttonActions() {
        JButton onePlay = new JButton("Single Player");
        JButton twoPlay = new JButton("Two Player");
        JButton resetPlay = new JButton("Reset");
        buttonPanel.add(onePlay);
        buttonPanel.add(twoPlay);
        buttonPanel.add(resetPlay);
        // TODO: addActionListeners here are some examples
        onePlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                player1Panel.decrementTurns();
            }
        });
        twoPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                player2Panel.decrementTurns();
            }
        });
    }
    public static void start() {
        JFrame frame = new JFrame("CS 449 Project");
        frame.setResizable(false);
        frame.setContentPane(new GameBoardGui().masterPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }
    public void playPiece () {
        for (int i = 0; i < 24; i ++) {
            final int temp = i;
            GamePanel.boardPieces.get(i).addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    if(aTurn && player1Panel.hasTurn()) {
                        gamePanel.addPlayer1Piece(GamePanel.boardPieces.get(temp));
                        player1Panel.decrementTurns();
                    }
                    else if (!aTurn && player2Panel.hasTurn()){
                        gamePanel.addPlayer2Piece(GamePanel.boardPieces.get(temp));
                        player2Panel.decrementTurns();
                    }
                    aTurn = !aTurn;
                }
            });
        }
    }
}
