import fjorde.Deck;
import fjorde.Textures;
import fjorde.Tile;
import fjorde.Tiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Map;


/**
 * @author Alexandre BAPTISTE
 */
public class ClosedDraw extends JPanel implements ActionListener{

    private JButton drawButton;
    private JButton depositButton;
    JButton tileButton;
    private Deck closedDeck;
    private Deck openedDeck;

    public void actionPerformed(ActionEvent e) {

        if ( e.getSource() == drawButton ) {
            closedDeck.draw();
            repaint();
        }

        if ( e.getSource() == depositButton ) {
            openedDeck.deposit(closedDeck.draw());
        }
    }

    public Deck getOpenedDeck(){ return this.openedDeck; }

    public ClosedDraw() {
        closedDeck = new Deck(40);
        Map<String, Image> textures = Textures.load(new File("img"));
        Tile tile = closedDeck.draw();
        Image texture = textures.get(tile.getSymbol() + ".png");

        setLayout(new GridLayout(2,1));
        tileButton = new JButton( new ImageIcon(texture));
        drawButton = new JButton("Draw");
        depositButton = new JButton("Deposit");

        add(tileButton);
        add(drawButton);
        add(depositButton);
        drawButton.addActionListener(this);
        depositButton.addActionListener(this);
    }

}
