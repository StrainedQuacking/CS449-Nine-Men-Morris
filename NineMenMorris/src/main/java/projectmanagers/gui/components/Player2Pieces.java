package main.java.projectmanagers.gui.components;

import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Player2Pieces extends JButton {
    //Potential to add draggable attributes

    public Player2Pieces() {
        super();
    }

    private int getDiameter() {
        int diameter = Math.min(getWidth(), getHeight());
        return diameter;
    }
    @Override
    public void paintComponent(Graphics g) {
        int diameter = getDiameter();
        int radius = diameter/2;
        g.setColor(Color.black);
        g.drawOval(getWidth()/2 - radius, getHeight()/2 - radius, diameter, diameter);
        g.setColor(Color.blue);
        g.fillOval(getWidth()/2 - radius, getHeight()/2 - radius, diameter, diameter);
    }
}

