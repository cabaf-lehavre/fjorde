package fjorde;

import fjorde.items.Jail;
import fjorde.items.Pawn;

import java.util.List;

/**
 * @author Alexandre BAPTISTE
 * @author Antoine CHAUVIN
 */
public class Bag {

    private List<PlayerItem> remaining;
    private final Player player;
    private int remainingJails;
    private int remainingPawns;
    private int i=0, j=0;


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

    public int getSize(){
        return remaining.size();
    }
}
