package main.java.projectmanagers.gui.components;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoardPieces extends JButton {

    private boolean mouseOver = false;
    private boolean mousePressed = false;
    private boolean mouseClicked = false;

    public BoardPieces() {
        //Mouse actions to make the circle have button attributes
        MouseAdapter mouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent me) {
                if(contains(me.getX(), me.getY())) {
                    mouseClicked = true;
                    repaint();
                }
            }
            @Override
            public void mousePressed(MouseEvent me) {
                if(contains(me.getX(), me.getY())) {
                    mousePressed = true;
                    repaint();
                }
            }
            @Override
            public void mouseReleased(MouseEvent me) {
                mousePressed = false;
                repaint();
            }
            @Override
            public void mouseExited(MouseEvent me) {
                mouseOver = false;
                mousePressed = false;
                repaint();
            }
            @Override
            public void mouseMoved(MouseEvent me) {
                mouseOver = contains(me.getX(), me.getY());
                repaint();
            }
        };
        addMouseListener(mouseListener);
        addMouseMotionListener(mouseListener);
    }

    private int getDiameter() {
        int diameter = Math.min(getWidth(), getHeight());
        return diameter;
    }
    @Override
    public boolean contains (int x, int y) {
        int radius = getDiameter()/2;
        return Point2D.distance(x, y, getWidth()/2, getHeight()/2) < radius;
    }
    @Override
    public void paintComponent(Graphics g) {
        int diameter = getDiameter();
        int radius = diameter/2;

        //Clickable display for current board position
        if (mousePressed)
            g.setColor(Color.darkGray);
        else
            g.setColor(Color.black);
        //fill oval will change the color of the inside of the circle
        g.fillOval(getWidth() / 2 - radius, getHeight() / 2 - radius, diameter, diameter);
        //Select a board position
        if (mouseClicked && (g.getColor() == Color.black || g.getColor() == Color.darkGray)) {
            g.setColor(Color.blue);
            g.fillOval(getWidth() / 2 - radius, getHeight() / 2 - radius, diameter, diameter);
        }
        //Highlight the current board selection
        if (mouseOver && g.getColor() == Color.black)
            g.setColor(Color.yellow);
        else
            g.setColor(Color.black);
        //Draw oval only changes the outline of the circle
        g.drawOval(getWidth() / 2 - radius, getHeight() / 2 - radius, diameter, diameter);
        g.setColor(Color.black);
    }
}

