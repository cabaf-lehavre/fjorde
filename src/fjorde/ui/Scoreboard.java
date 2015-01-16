package fjorde.ui;

import fjorde.Game;
import fjorde.Player;

import javax.swing.*;
import java.awt.*;

/**
 * @author Alexandre BAPTISTE
 */
public class Scoreboard extends JPanel{

    private Game game;

    JLabel playerOneScore = new JLabel();
    JLabel playerTwoScore = new JLabel();
    JButton playerOne = new JButton();
    JButton playerTwo = new JButton();

    public Scoreboard(Game game) {
        this.game = game;

        setLayout(null);

        playerOne.setBackground(Color.WHITE);
        playerOne.setIcon( new ImageIcon("img/barbare1.jpg"));
        playerOne.setBounds(10,50,50,63);

        playerTwo.setBackground(Color.WHITE);
        playerTwo.setIcon( new ImageIcon("img/barbare2.png"));
        playerTwo.setBounds(10,130,64,50);

        update();
        playerOneScore.setBounds(80,55,100,100);
        playerTwoScore.setBounds(80,120,100,100);

        add(playerOne);
        add(playerTwo);
        add(playerOneScore);
        add(playerTwoScore);
    }

    public void update() {
        Player player_one = game.getFirstPlayer(),
                player_two = game.getSecondPlayer();

        playerOneScore.setText(player_one.getName() + ": " + player_one.getScore());
        playerTwoScore.setText(player_two.getName() + ": " + player_two.getScore());
    }

}
