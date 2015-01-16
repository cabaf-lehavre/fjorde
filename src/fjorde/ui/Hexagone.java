package fjorde.ui; /**
 * @author Alexandre BAPTISTE
 */

import fjorde.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Hexagone extends JFrame {

    Game game;
    Plateau panelPlateau;
    JPanel panelPioches;
    JailsPawn[] jailsPawns;
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

		jailsPawns = new JailsPawn[]{
            new JailsPawn(first),
            new JailsPawn(second),
        };
        scoreBoard = new Scoreboard(game);
        draw = new Draw(game, scoreBoard);

        panelPioches = new JPanel(new GridLayout(3, 1));
        panelPioches.add(draw);
        panelPioches.add(jailsPawns[game.getCurrentTurnIndex()]);
        panelPioches.add(scoreBoard);

        add(panelPlateau);
        add(panelPioches, BorderLayout.EAST);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setTitle("Fjorde");
        setLocation(dim.width / 20, dim.height / 20);
        setSize(975,665);
        setDefaultCloseOperation(3);
        setVisible(true);
    }

    void updateJailsPawn() {
        JailsPawn jp = getCurrentJailsPawn();
        panelPioches.remove(1);
        panelPioches.add(jp, 1);
        jp.updateCounters();
        repaint();
    }

    JailsPawn getCurrentJailsPawn() {
        return jailsPawns[game.getCurrentTurnIndex()];
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
                Turn turn = game.getCurrentTurn();

                Tile selectedTile = draw.getSelectedTile();
                if (selectedTile != null) {
                    if (turn.canMoveTile() && panelPlateau.clic(x, y, selectedTile)) {
                        turn.incNrTilesMoved();
                    } else {
                        draw.putTile(selectedTile);
                    }
                }

                JailsPawn jailsPawn = getCurrentJailsPawn();
                PlayerItem selectedItem = jailsPawn.getSelectedItem();
                if (selectedItem != null) {
                    if (turn.canMove(selectedItem) && panelPlateau.clic(x, y, selectedItem)) {
                        turn.incNrItemsMoved();
                    } else {
                        jailsPawn.putItem(selectedItem);
                    }
                }

                game.tryPassTurn();
                scoreBoard.update();
                updateJailsPawn();
            }
        }
    }

    public static void main(String[] args) {
        new Hexagone();
    }
}
