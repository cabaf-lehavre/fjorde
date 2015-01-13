import fjorde.Bag;
import fjorde.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Alexandre BAPTISTE
 */

public class JailsPawn extends JPanel implements ActionListener{

    JButton jailButton;
    JButton pawnButton;
    JLabel remainingJails;
    JLabel remainingPaws;
    Player player = new Player(1,"Stephen","Noir");
    Bag bag = new Bag(player,4,20);
    int buttonSelection;


    public void actionPerformed(ActionEvent e) {
        if ( e.getSource() == jailButton ) {
            if (buttonSelection != 1) {
                buttonSelection = 1;
                jailButton.setBackground(Color.red);
                pawnButton.setBackground(Color.white);
            } else {
                clearSelection();
            }
        }

        if ( e.getSource() == pawnButton ) {
            if (buttonSelection != 2) {
                buttonSelection = 2;
                pawnButton.setBackground(Color.red);
                jailButton.setBackground(Color.white);
            } else {
                clearSelection();
            }
        }
    }

    public JailsPawn() {
        setLayout(new GridLayout(2,1));

        jailButton = new JButton();
        pawnButton = new JButton();
        remainingJails = new JLabel();
        remainingPaws = new JLabel();

        jailButton.setBackground(Color.WHITE);
        pawnButton.setBackground(Color.WHITE);
        jailButton.setIcon(new ImageIcon("img/jail.png"));
        pawnButton.setIcon(new ImageIcon("img/pawn.png"));

        updateCounters();

        add(jailButton);
        add(remainingJails);
        add(pawnButton);
        add(remainingPaws);

        jailButton.addActionListener(this);
        pawnButton.addActionListener(this);
    }

    private void updateCounters() {
        remainingJails.setText("       x    " + bag.getRemainingJails());
        remainingPaws.setText("        x   " + bag.getRemainingPawns());
    }

    private void clearSelection() {
        buttonSelection = 0;
        jailButton.setBackground(Color.white);
        pawnButton.setBackground(Color.white);
    }

}
