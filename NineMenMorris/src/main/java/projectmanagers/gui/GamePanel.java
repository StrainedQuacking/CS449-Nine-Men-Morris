package main.java.projectmanagers.gui;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private GridBagConstraints gbc;

    public GamePanel () {
        super();
        buildBoard();
    }
    public void buildBoard () {
        gbc = new GridBagConstraints();
        gbc.weighty = 0.1; gbc.weightx = 0.1;
        setLayout(new GridBagLayout());
        setBackground(new Color(153,133,97));
    }
}
