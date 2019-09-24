package main.java.projectmanagers.gui.panels;
import javax.swing.*;
import java.awt.*;

public class Player2Panel extends JPanel {
    public JLabel player2Txt;
    private int turns = 9;
    private GridBagConstraints gbc;

    public Player2Panel () {
        gbc = new GridBagConstraints();
        player2Txt = new JLabel("Player 2");
        buildPanel();
    }
    public void buildPanel () {
        gbc.weighty = 0.1;   gbc.gridy = 0;   gbc.gridx = 0;
        setLayout(new GridBagLayout());
        setBackground(new Color(116,101,72));
        setPreferredSize(new Dimension(75,600));
        player2Txt.setHorizontalAlignment(SwingConstants.CENTER);
        add(player2Txt, gbc);
        trackTurns();
    }
    public void trackTurns () {
        for (int i = 1; i <= turns; i++) {
            gbc.gridy = i;
        }
    }
}
