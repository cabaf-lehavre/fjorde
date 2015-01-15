package fjorde.ui; /**
 * @author Alexandre BAPTISTE
 */

import fjorde.Bag;
import fjorde.Player;
import fjorde.PlayerItem;
import fjorde.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Hexagone extends JFrame {

    Plateau panelPlateau;
    JailsPawn jailsPawn;
    Draw draw;
    Scoreboard scoreBoard;

    /**
     * Main UI, adding all panel, managers ...
     */
    public Hexagone() {
        panelPlateau = new Plateau();
        panelPlateau.setBackground(Color.white);
        panelPlateau.setLayout(null);
        panelPlateau.addMouseListener(new MouseManager());

        Player michael = new Player(1, "Mickael", "Noir", new Bag(4, 20));
        Player bay = new Player(1, "Fucking Bay", "Noir", new Bag(4, 20));

        jailsPawn = new JailsPawn(michael);
        scoreBoard = new Scoreboard(michael, bay);
        draw = new Draw();

        JPanel panelPioches = new JPanel(new GridLayout(3, 1));
        panelPioches.add(draw);
        panelPioches.add(jailsPawn);
        panelPioches.add(scoreBoard);

        add(panelPlateau);
        add(panelPioches, BorderLayout.EAST);

        setTitle("Fjorde");
        setLocation(500, 200);
        setSize(1025,740);
        setDefaultCloseOperation(3);
        setVisible(true);
    }

    private class MouseManager extends MouseAdapter
    {
        private MouseManager() {}

        /**
         * mouse has some button, define which button action
         * @param paramMouseEvent
         */
        public void mousePressed(MouseEvent paramMouseEvent)
        {
            int x = paramMouseEvent.getX(),
                    y = paramMouseEvent.getY();

            if ( paramMouseEvent.getButton() == 1) {
                Tile selectedTile = draw.getSelectedTile();
                if (selectedTile != null) {
                    panelPlateau.clic(x, y, selectedTile);
                }

                PlayerItem selectedItem = jailsPawn.getSelectedItem();
                if (selectedItem != null) {
                    panelPlateau.clic(x, y, selectedItem);
                }

            }
        }
    }

    public static void main(String[] args) {
        new Hexagone();
    }
}