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

    private Color[] tabCoul = {Color.RED, Color.WHITE, Color.BLACK, Color.GREEN, Color.YELLOW, Color.CYAN, Color.MAGENTA, Color.LIGHT_GRAY, Color.BLUE };
    private Plateau panelPlateau;
    private JPanel panelPioches;
    private JPanel panelClosedDraw;
    private JPanel panelOpenedDraw;
    private JPanel panelJailsPawn;
    private java.util.List<Tile> tileList;
    private Deck deck;

    public Hexagone() {
        setTitle("Fjorde");
        setLocation(200, 200);
        setSize(500,500);
        setDefaultCloseOperation(3);
        GestionSouris localGestionSouris = new GestionSouris();

        panelPlateau = new Plateau();
        panelPlateau.setBackground(tabCoul[1]);
        panelPlateau.setLayout(null);
        add(panelPlateau);
        panelPlateau.addMouseListener(localGestionSouris);

        panelPioches = new JPanel(new GridLayout(3, 1));
        panelClosedDraw = new ClosedDraw();
        panelOpenedDraw = new OpenedDraw();
        panelJailsPawn = new JailsPawn();
        panelPioches.add(panelClosedDraw);
        panelPioches.add(panelOpenedDraw);
        panelPioches.add(panelJailsPawn);
        add(panelPioches, BorderLayout.EAST);
        setVisible(true);
    }

    private class GestionSouris extends MouseAdapter
    {
        private GestionSouris() {}

        public void mousePressed(MouseEvent paramMouseEvent)
        {
            if ( paramMouseEvent.getButton() == 1) {
                panelPlateau.clic(paramMouseEvent.getX(),paramMouseEvent.getY());
            }
        }
    }

    public static void main(String[] args) {
        Hexagone hex = new Hexagone();
    }
}