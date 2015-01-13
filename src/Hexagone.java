/**
 * @author Alexandre BAPTISTE
 */

import fjorde.Deck;
import fjorde.Tile;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;

public class Hexagone extends JFrame {

    Color[] tabCoul = {Color.RED, Color.WHITE, Color.BLACK, Color.GREEN, Color.YELLOW, Color.CYAN, Color.MAGENTA, Color.LIGHT_GRAY, Color.BLUE };
    Plateau panelPlateau;
    JPanel panelPioches;
    JPanel panelClosedDraw;
    JPanel panelOpenedDraw;
    JPanel panelJailsPawn;
    JPanel panelDraw;
    private java.util.List<Tile> tileList;
    private Deck deck;

    public Hexagone() {
        setTitle("Fjorde");
        setLocation(1250, 0);
        setSize(500,500);
        setDefaultCloseOperation(3);
        mouseManager localMouseManager = new mouseManager();

        panelPlateau = new Plateau();
        panelPlateau.setBackground(tabCoul[1]);
        panelPlateau.setLayout(null);
        add(panelPlateau);
        panelPlateau.addMouseListener(localMouseManager);

        panelPioches = new JPanel(new GridLayout(2, 1));
        panelJailsPawn = new JailsPawn();
        panelDraw = new Draw();

        panelPioches.add(panelDraw);
        panelPioches.add(panelJailsPawn);

        add(panelPioches, BorderLayout.EAST);
        setVisible(true);
    }

    private class mouseManager extends MouseAdapter
    {
        private mouseManager() {}

        public void mousePressed(MouseEvent paramMouseEvent)
        {
            if ( paramMouseEvent.getButton() == 1) {
                panelPlateau.clic(paramMouseEvent.getX(),paramMouseEvent.getY());
            }
        }
    }

    public static void main(String[] args) {
        new Hexagone();
    }
}