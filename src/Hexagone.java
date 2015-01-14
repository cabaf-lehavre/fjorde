/**
 * @author Alexandre BAPTISTE
 */

import fjorde.Player;
import fjorde.PlayerItem;
import fjorde.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Hexagone extends JFrame {

    Plateau panelPlateau;
    JPanel panelPioches;
    JailsPawn jailsPawn;
    Draw draw;
    ScoreBoard scoreBoard;
    Player player = new Player(1,"Stephen","Noir");
    Player player2 = new Player(1,"Dark vador","Noir");

    /**
     * Main UI, adding all panel, managers ...
     */
    public Hexagone() {
        setTitle("Fjorde");
        setLocation(500, 200);
        setSize(1025,740);
        setDefaultCloseOperation(3);
        mouseManager localMouseManager = new mouseManager();

        panelPlateau = new Plateau();
        panelPlateau.setBackground(Color.white);
        panelPlateau.setLayout(null);
        add(panelPlateau);
        panelPlateau.addMouseListener(localMouseManager);

        panelPioches = new JPanel(new GridLayout(3, 1));
        jailsPawn = new JailsPawn();
        draw = new Draw();
        scoreBoard = new ScoreBoard(player,player2);
        panelPioches.add(draw);
        panelPioches.add(jailsPawn);
        panelPioches.add(scoreBoard);


        add(panelPioches, BorderLayout.EAST);
        setVisible(true);
    }

    private class mouseManager extends MouseAdapter
    {
        private mouseManager() {}

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