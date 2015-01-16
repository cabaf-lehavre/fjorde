package fjorde.ui; /**
 * @author Alexandre BAPTISTE
 */

import fjorde.Bag;
import fjorde.Game;
import fjorde.Player;
import fjorde.PlayerItem;
import fjorde.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Hexagone extends JFrame {

    Game game;
    Plateau panelPlateau;
    JailsPawn jailsPawn;
    Draw draw;
    Scoreboard scoreBoard;

    /**
     * Main UI, adding all panel, managers ...
     */
    public Hexagone() {
        Player first  = new Player(1, "Falsimor", "Noir", new Bag(4, 20));
        Player second = new Player(1, "Dùnwyn",   "Noir", new Bag(4, 20));
        game = new Game(first, second);

        panelPlateau = new Plateau();
        panelPlateau.setBackground(Color.white);
        panelPlateau.setLayout(null);
        panelPlateau.addMouseListener(new MouseManager());

		jailsPawn = new JailsPawn(first);
        scoreBoard = new Scoreboard(game);
        draw = new Draw();

        JPanel panelPioches = new JPanel(new GridLayout(3, 1));
        panelPioches.add(draw);
        panelPioches.add(jailsPawn);
        panelPioches.add(scoreBoard);

        add(panelPlateau);
        add(panelPioches, BorderLayout.EAST);

        setTitle("Fjorde");
        setLocation(500, 200);
        setSize(975,665);
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
                    if (!panelPlateau.clic(x, y, selectedTile)) {
                        draw.putTile(selectedTile);
                    }
                }

                PlayerItem selectedItem = jailsPawn.getSelectedItem();
                if (selectedItem != null) {
                    if (!panelPlateau.clic(x, y, selectedItem)) {
                        jailsPawn.putItem(selectedItem);
                    }
                }

                scoreBoard.update();
            }
        }
    }

    public static void main(String[] args) {
        new Hexagone();
    }
}
