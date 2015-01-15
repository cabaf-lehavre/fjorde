package fjorde;

/**
 * @author Antoine CHAUVIN INFOB1
 */
public class Game {
    private final Player[] players;

    private int currentPlayer;

    public Game(Player left, Player right) {
        this.players = new Player[]{left, right};
    }

    public Player getPlayer(int i) {
        return players[i];
    }

    public Player getFirstPlayer() {
        return getPlayer(0);
    }

    public Player getSecondPlayer() {
        return getPlayer(1);
    }

    public int getCurrentPlayerIndex() {
        return currentPlayer;
    }

    public Player getCurrentPlayer() {
        return players[currentPlayer];
    }

    public void passTurn() {
        currentPlayer = 1 - currentPlayer;
    }

    public Player getWinner() {
        if (players[0].getScore() == 0) {
            return players[0];
        } else if (players[1].getScore() == 0) {
            return players[1];
        }
        return null;
    }

    public boolean isAlive() {
        return getWinner() == null;
    }
}
