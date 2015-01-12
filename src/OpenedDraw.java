import com.sun.xml.internal.bind.v2.TODO;
import fjorde.Deck;
import fjorde.Textures;
import fjorde.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Map;

/**
 * @author Alexandre BAPTISTE
 */
public class OpenedDraw extends JPanel implements ActionListener{

    JButton previousTile;
    JButton nextTile;
    ClosedDraw closedDraw;
    JButton tileButton;
    Deck deck;

    public void actionPerformed(ActionEvent e) {
    }

    public OpenedDraw() {

        Map<String, Image> textures = Textures.load(new File("img"));
        Tile tile = closedDraw.getOpenedDeck().draw();
        Image texture = textures.get(tile.getSymbol());


        setLayout(new GridLayout(2,1));

        previousTile = new JButton();
        nextTile = new JButton();
        previousTile.setBackground(Color.WHITE);
        nextTile.setBackground(Color.WHITE);
        ImageIcon previousArrow = new ImageIcon("img/previousArrow.png");
        ImageIcon nextArrow = new ImageIcon("img/nextArrow.jpg");
        previousTile.setIcon(previousArrow);
        nextTile.setIcon(nextArrow);

        tileButton = new JButton();
        ImageIcon tileIcon = new ImageIcon(texture);
        tileButton.setIcon(tileIcon);

        add(tileButton);
        add(previousTile);
        add(nextTile);
        previousTile.addActionListener(this);
        nextTile.addActionListener(this);
    }

}
