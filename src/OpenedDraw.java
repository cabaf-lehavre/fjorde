<<<<<<< HEAD
=======
import fjorde.Deck;
import fjorde.Textures;
import fjorde.Tile;
>>>>>>> dd92e55bdf383fabb61363d64912c008b77aa562

import fjorde.Tile;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author Alexandre BAPTISTE
 */

public class OpenedDraw extends JPanel implements ActionListener{

    JButton previousTile;
    JButton nextTile;
    JButton tileButton;
    private ClosedDraw deck;
    private int deckPos;

    /**
     * redefine actionPerformed to cross the deck
     * @param e an event,
     * here just pressing button
     */

    public void actionPerformed(ActionEvent e) {

        if ( e.getSource() == nextTile ) {
            deckPos++;
            if (deckPos >= deck.getOpenedDeck().getSize()) {
                deckPos = 0;
            }

            Tile tile = deck.getOpenedDeck().getTile(deckPos);
            tileButton.setIcon(new ImageIcon(String.format("img/%s.png", tile.getSymbol())));
            repaint();
        }

        if ( e.getSource() == previousTile ) {
            deckPos--;
            if (deckPos <= deck.getOpenedDeck().getSize() ) {
                deckPos = 0;
            }

            Tile tile = deck.getOpenedDeck().getTile(deckPos);
            tileButton.setIcon(new ImageIcon(String.format("img/%s.png", tile.getSymbol())));
            repaint();
        }

    }

    /**
     * Deck, buttons and stuff
     */
    public OpenedDraw() {

        setLayout(null);

        previousTile = new JButton();
        nextTile     = new JButton();
        tileButton   = new JButton();

        previousTile.setBackground(Color.WHITE);
        nextTile.setBackground(Color.WHITE);
        tileButton.setBackground(Color.WHITE);


        previousTile.setIcon(new ImageIcon("img/previousArrow.png"));
        nextTile.setIcon(new ImageIcon("img/nextArrow.jpg"));

        tileButton.setIcon(new ImageIcon("img/MMPPPM.png"));

        tileButton.setBounds(55,5,50,50);
        previousTile.setBounds(10,60,70,40);
        nextTile.setBounds(83,60,70,40);

        add(tileButton);
        add(previousTile);
        add(nextTile);

        previousTile.addActionListener(this);
        nextTile.addActionListener(this);
    }

}
