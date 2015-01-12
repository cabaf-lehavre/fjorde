import fjorde.Deck;

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
    GridLayout gridItems;
    Deck deck;

    public void actionPerformed(ActionEvent e) {
    }

    public JailsPawn() {
        setLayout(new GridLayout(2,1));
        jailButton = new JButton();
        pawnButton = new JButton();
        jailButton.setBackground(Color.WHITE);
        pawnButton.setBackground(Color.WHITE);
        ImageIcon jailIcon = new ImageIcon("img/jail.png");
        ImageIcon pawnIcon  = new ImageIcon("img/pawn.png");
        jailButton.setIcon(jailIcon);
        remainingJails = new JLabel("    x4");
        pawnButton.setIcon(pawnIcon);
        remainingPaws = new JLabel("    x20");
        jailButton.setBounds(250,250,50,50);

        add(jailButton);
        add(remainingJails);
        add(pawnButton);
        add(remainingPaws);
        jailButton.addActionListener(this);
    }

}
