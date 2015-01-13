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

    private int selectedDeck;

    JButton previousTile;
    JButton nextTile;
    JButton openedTileButton;

    JButton drawButton;
    JButton depositButton;
    JButton closedTileButton;

    public void closedDraw() {
        closed.draw(); // draw and forget
        updateSprites();
    }

    public void closedDeposit(){
        opened.deposit(closed.draw()); // draw and put in open deck
        updateSprites();
    }

    public void updateSprites() {
        Tile cls = closed.peek();
        if (cls != null) {
            closedTileButton.setIcon(new ImageIcon(String.format("img/tiles/%s.png", cls.getSymbol())));
        } else {
            closedTileButton.setIcon(null);
        }

        Tile opn = opened.peek();
        if (opn != null) {
            openedTileButton.setIcon(new ImageIcon(String.format("img/tiles/%s.png", opn.getSymbol())));
        } else {
            openedTileButton.setIcon(null);
        }

        repaint();
    }

    public void previousOpened(){
        opened.shiftLeft();
        updateSprites();
    }

    public void nextOpened(){
        opened.shiftRight();
        updateSprites();
    }

    public Draw(){
        setLayout(null);

        drawButton    = new JButton("Draw");
        depositButton = new JButton("Deposit");

        previousTile     = new JButton();
        nextTile         = new JButton();
        closedTileButton = new JButton();
        openedTileButton = new JButton();


        previousTile.setBackground(Color.WHITE);
        nextTile.setBackground(Color.WHITE);
        closedTileButton.setBackground(Color.WHITE);
        openedTileButton.setBackground(Color.WHITE);
        previousTile.setIcon(new ImageIcon("img/previousArrow.png"));
        nextTile.setIcon(new ImageIcon("img/nextArrow.jpg"));


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
        openedTileButton.addActionListener(this);
        closedTileButton.addActionListener(this);

        updateSprites();
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
            selectedDeck = 1;
            openedTileButton.setBackground(Color.red);
            closedTileButton.setBackground(Color.white);
        }

        if ( e.getSource() == closedTileButton ) {
            selectedDeck = 2;
            openedTileButton.setBackground(Color.white);
            closedTileButton.setBackground(Color.red);
        }

        if ( e.getSource() == drawButton ) {
            closedDraw();
        }

        if ( e.getSource() == depositButton ) {
            closedDeposit();
        }
    }

    public Tile getSelectedTile() {
        try {
            if (selectedDeck == 1) {
                return opened.draw();
            } else if (selectedDeck == 2) {
                return closed.draw();
            } else {
                throw new IllegalStateException("no deck selected");
            }
        } finally {
            selectedDeck = 0;
            openedTileButton.setBackground(Color.white);
            closedTileButton.setBackground(Color.white);
        }
    }
}
