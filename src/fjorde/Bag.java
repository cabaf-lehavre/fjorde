package fjorde;

import fjorde.items.Jail;
import fjorde.items.Pawn;

/**
 * @author Alexandre BAPTISTE
 * @author Antoine CHAUVIN
 */
public class Bag {
    private final Player player;
    private int remainingJails;
    private int remainingPawns;

    public Bag( Player player, int remainingJails, int remainingPawns ){
        this.player = player;
        this.remainingJails = remainingJails;
        this.remainingPawns = remainingPawns;

    }

    public int getRemainingJails(){
        return remainingJails;
    }

    public int getRemainingPawns() {
        return remainingPawns;
    }

    public Player getPlayer() {
        return player;
    }

    public Pawn getPawn() {
        remainingPawns --;
        return new Pawn(player);
    }

    public Jail getJail() {
        remainingJails --;
        return new Jail(player);
    }

    public void put(PlayerItem item) {
        if (item instanceof Pawn) {
            remainingPawns++;
        } else if (item instanceof Jail) {
            remainingJails++;
        }
    }
}
