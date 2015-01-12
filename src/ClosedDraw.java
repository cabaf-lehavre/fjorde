import fjorde.Deck;
import fjorde.Tile;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Alexandre BAPTISTE
 */

public class ClosedDraw extends JPanel implements ActionListener{

    private JButton drawButton;
    private JButton depositButton;
    JButton tileButton;
    private Deck closedDeck = new Deck(40);
    private Deck openedDeck;

    public void actionPerformed(ActionEvent e) {

        if ( e.getSource() == tileButton ) {

        }

        if ( e.getSource() == drawButton ) {
            Tile tile = closedDeck.draw();
            tileButton.setIcon(new ImageIcon(String.format("img/%s.png", tile.getSymbol())));
            repaint();
        }

        if ( e.getSource() == depositButton ) {
            openedDeck.deposit(closedDeck.draw());
        }
    }

    public Deck getOpenedDeck(){ return this.openedDeck; }

    public ClosedDraw() {
        setLayout(null);
        tileButton = new JButton( new ImageIcon("img/MMPSSP.png"));
        tileButton.setBackground(Color.WHITE);

        drawButton    = new JButton("Draw");
        depositButton = new JButton("Deposit");

        tileButton.setBounds(55,5,50,50);
        drawButton.setBounds(10,60,70,40);
        depositButton.setBounds(83,60,70,40);

        add(tileButton);
        add(drawButton);
        add(depositButton);

        drawButton.addActionListener(this);
        depositButton.addActionListener(this);
    }
}
