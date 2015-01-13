import fjorde.Deck;
import fjorde.Tile;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Alexandre BAPTISTE
 */
public class Draw extends JPanel implements ActionListener {

    private Deck opened = new Deck(0);
    private Deck closed = new Deck(40);
    private int deckPos;

    JButton previousTile;
    JButton nextTile;
    JButton openedTileButton;

    JButton drawButton;
    JButton depositButton;
    JButton closedTileButton;

    public void closedDraw() {
        Tile tile = closed.draw();
        closedTileButton.setIcon(new ImageIcon(String.format("img/%s.png", tile.getSymbol())));
        repaint();
    }

    public void closedDeposit(){
        opened.deposit(closed.draw());
    }

    public Tile previousOpened(){
        deckPos--;
        if (deckPos < 0) {
            deckPos = opened.getSize();
        }

        Tile tile = opened.getTile(deckPos);
        openedTileButton.setIcon(new ImageIcon(String.format("img/%s.png", tile.getSymbol())));
        repaint();
        return tile;
    }

    public Tile nextOpened(){
        deckPos++;
        if (deckPos > opened.getSize()) {
            deckPos = 0;
        }

        Tile tile = opened.getTile(deckPos);
        openedTileButton.setIcon(new ImageIcon(String.format("img/%s.png", tile.getSymbol())));
        repaint();
        return tile;
    }

    public Draw(){
        setLayout(null);

        closedTileButton = new JButton( new ImageIcon("img/MMPSSP.png"));
        closedTileButton.setBackground(Color.WHITE);

        drawButton    = new JButton("Draw");
        depositButton = new JButton("Deposit");

        previousTile = new JButton();
        nextTile     = new JButton();
        openedTileButton   = new JButton();


        previousTile.setBackground(Color.WHITE);
        nextTile.setBackground(Color.WHITE);
        openedTileButton.setBackground(Color.WHITE);
        previousTile.setIcon(new ImageIcon("img/previousArrow.png"));
        nextTile.setIcon(new ImageIcon("img/nextArrow.jpg"));
        openedTileButton.setIcon(new ImageIcon("img/MMPPPM.png"));


        closedTileButton.setBounds(55,5,50,50);
        drawButton.setBounds(10,60,70,40);
        depositButton.setBounds(83,60,70,40);
        openedTileButton.setBounds(55,110,50,50);
        previousTile.setBounds(10,165,70,40);
        nextTile.setBounds(83,165,70,40);

        add(closedTileButton);
        add(drawButton);
        add(depositButton);
        add(openedTileButton);
        add(previousTile);
        add(nextTile);

        previousTile.addActionListener(this);
        nextTile.addActionListener(this);
        drawButton.addActionListener(this);
        depositButton.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if ( e.getSource() == nextTile ) {
            nextOpened();
        }

        if ( e.getSource() == previousTile ) {
            previousOpened();
        }

        if ( e.getSource() == openedTileButton ) {

        }

        if ( e.getSource() == closedTileButton ) {

        }

        if ( e.getSource() == drawButton ) {
            closedDraw();
        }

        if ( e.getSource() == depositButton ) {
            closedDeposit();
        }
    }
}
