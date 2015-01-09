import fjorde.Deck;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Alexandre BAPTISTE
 */
public class ClosedDraw extends JPanel implements ActionListener{

    private JButton drawButton;
    private JButton depositButton;
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
        drawButton = new JButton("Draw");
        depositButton = new JButton("Deposit");
        add(drawButton);
        add(depositButton);
        drawButton.addActionListener(this);
        depositButton.addActionListener(this);
    }

}
