import java.util.LinkedList;

/**
 * Created by Hawk on 06/01/2015.
 */

public class Deck {

    private List<Tile> remaining;

    private Deck( Tile[] remaining){
        remaining = new LinkedList<Tile>(40);
    }


    // Drawn last Tile in the deck
    public Tile draw() {
        return remaining.remove(0);
    }

    private List<Tile> draw(int nbTile) {
        List<Tile> res = new LinkedList<>();
        for (int i = 0; i < nbTile; i++) {
            res.add(Draw());
        }
        return res;
    }
}
