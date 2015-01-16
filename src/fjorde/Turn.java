package fjorde;

/**
 * @author Antoine CHAUVIN INFOB1
 */
public class Turn {
    private final Player player;

    private int nrTilesMoved;
    private int nrItemsMoved;

    public Turn(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public int getNrTilesMoved() {
        return nrTilesMoved;
    }

    public void incNrTilesMoved() {
        nrTilesMoved++;
    }

    public int getNrItemsMoved() {
        return nrItemsMoved;
    }

    public void incNrItemsMoved() {
        nrItemsMoved++;
    }

    public boolean canMoveTile() {
        return nrTilesMoved < 1;
    }

    public boolean canMoveItem() {
        return nrItemsMoved < 1;
    }

    public boolean hasJails() {
        return player.getBag().getRemainingJails() > 0;
    }

    public boolean hasPawns() {
        return player.getBag().getRemainingPawns() > 0;
    }

    public boolean canMoveJail() {
        return !canMoveTile() && canMoveItem() && hasJails();
    }

    public boolean canMovePawn() {
        return !canMoveTile() && canMoveItem() && !hasJails() && hasPawns();
    }

    public boolean isOver() {
        return !canMovePawn();
    }
}
