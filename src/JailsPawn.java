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


    public void actionPerformed(ActionEvent e) {
        if ( e.getSource() == jailButton ) {

        }

        if ( e.getSource() == pawnButton ) {

        }
    }

    public JailsPawn() {

        setLayout(new GridLayout(2,1));

        jailButton = new JButton();
        pawnButton = new JButton();

        jailButton.setBackground(Color.WHITE);
        pawnButton.setBackground(Color.WHITE);

        jailButton.setIcon(new ImageIcon("img/jail.png"));
        remainingJails = new JLabel("       x    " + bag.getRemainingJails() );
        pawnButton.setIcon(new ImageIcon("img/pawn.png"));
        remainingPaws = new JLabel("        x   "  + bag.getRemainingPawns() );

        add(jailButton);
        add(remainingJails);
        add(pawnButton);
        add(remainingPaws);
        jailButton.addActionListener(this);
    }

}
