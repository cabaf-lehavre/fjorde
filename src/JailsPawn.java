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
    Deck deck;

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
<<<<<<< HEAD

        jailButton.setIcon(new ImageIcon("img/jail.png"));
        remainingJails = new JLabel("       x    4");
        pawnButton.setIcon(new ImageIcon("img/pawn.png"));
        remainingPaws = new JLabel("        x 20");


        add(jailButton,BorderLayout.CENTER);
=======
        ImageIcon jailIcon = new ImageIcon("img/jail.png");
        ImageIcon pawnIcon  = new ImageIcon("img/pawn.png");
        jailButton.setIcon(jailIcon);
        remainingJails = new JLabel("    x4");
        pawnButton.setIcon(pawnIcon);
        remainingPaws = new JLabel("    x20");
        jailButton.setBounds(250,250,50,50);

        add(jailButton);
>>>>>>> dd92e55bdf383fabb61363d64912c008b77aa562
        add(remainingJails);
        add(pawnButton);
        add(remainingPaws);
        jailButton.addActionListener(this);
    }

}
