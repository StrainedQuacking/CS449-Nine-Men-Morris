package main.java.projectmanagers.gui.components;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayerPieces extends JButton {
    //Potential to add draggable attributes
    private Color bg;
    private Color outline;
    private int diameter = Math.min(getWidth() / 2, getHeight() / 2);

    public PlayerPieces(Color bg, Color outline) {
        super();
        this.bg = bg;
        this.outline = outline;
    }
    public void setBg (Color bg)
    {
        this.bg = bg;
    }
    public void setOL (Color outline)
    {
        this.outline = outline;
    }
    public void setDiameter(int size) {
        diameter = size;
    }
    @Override
    public void paintComponent(Graphics g) {
        int radius = diameter/2;
        g.setColor(outline);
        g.drawOval(getWidth()/2 - radius, getHeight()/2 - radius, diameter, diameter);
        g.setColor(bg);
        g.fillOval(getWidth()/2 - radius, getHeight()/2 - radius, diameter, diameter);
    }
}

