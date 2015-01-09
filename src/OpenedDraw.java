import fjorde.Deck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Alexandre BAPTISTE
 */
public class OpenedDraw extends JPanel implements ActionListener{

    private JButton previousTile;
    private JButton nextTile;
    private Deck deck;
    public void actionPerformed(ActionEvent e) {
    }

    public OpenedDraw() {
        //deck = new Deck();
        previousTile = new JButton();
        nextTile = new JButton();
        previousTile.setBackground(Color.WHITE);
        nextTile.setBackground(Color.WHITE);
        ImageIcon previousArrow = new ImageIcon("img/previousArrow.png");
        ImageIcon nextArrow = new ImageIcon("img/nextArrow.jpg");
        previousTile.setIcon(previousArrow);
        nextTile.setIcon(nextArrow);
        add(previousTile);
        add(nextTile);
        previousTile.addActionListener(this);
        nextTile.addActionListener(this);
    }

}
