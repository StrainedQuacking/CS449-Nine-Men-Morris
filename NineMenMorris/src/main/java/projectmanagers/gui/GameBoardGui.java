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
    private boolean isMill = false;
    private boolean twoPlayerGame = false;

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
        movePlayerPiece();
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
        buttonPanel.add(onePlay);
        buttonPanel.add(twoPlay);
        // TODO: addActionListeners here are some examples
        onePlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "CPU doesn't exist...", "ERROR", JOptionPane.ERROR_MESSAGE);
                gamePanel.removeAll();
                gamePanel.buildBoard();
            }
        });
        twoPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                JOptionPane.showMessageDialog(null, "START!");
                twoPlayerGame = true;
            }
        });
    }
    public static void start() {
        JFrame frame = new JFrame("CS 449 Project");
        frame.setResizable(true);
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
                    if(twoPlayerGame) {
                        if (aTurn && player1Panel.hasTurn()) {
                            gamePanel.addPlayer1Piece(GamePanel.boardPieces.get(temp));
                            player1Panel.decrementTurns();
                            aTurn = !aTurn;
                        } else if (!aTurn && player2Panel.hasTurn()) {
                            gamePanel.addPlayer2Piece(GamePanel.boardPieces.get(temp));
                            player2Panel.decrementTurns();
                            aTurn = !aTurn;
                        }
                    }
                }
            });
        }
    }
    public void movePlayerPiece () {
        for(int i = 0; i < GamePanel.player1Pieces.size(); i++) {
            final int temp = i;
            gamePanel.player1Pieces.get(i).addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    if(!player1Panel.hasTurn() && !player2Panel.hasTurn()) {
                        if(isMill)
                            gamePanel.millPlayer1Remove(gamePanel.player1Pieces.get(temp));
                        aTurn = !aTurn;
                    }
                }
            });
        }
    }
}
