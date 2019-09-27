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
    @Override
    public void paintComponent(Graphics g) {
        int diameter = 28;
        int radius = diameter/2;
        g.setColor(outline);
        g.drawOval(getWidth()/2 - radius, getHeight()/2 - radius, diameter, diameter);
        g.setColor(bg);
        g.fillOval(getWidth()/2 - radius, getHeight()/2 - radius, diameter, diameter);
    }
}

