package fjorde;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alexandre BAPTISTE
 */
public class Deck {

    private List<Tile> remaining;

    private Deck( List<Tile> remaining){
        remaining = new LinkedList<Tile>();
        Collections.shuffle(remaining);
    }


    // Drawn last Tile in the deck
    public Tile draw() {
        return remaining.remove(0);
    }

    private List<Tile> draw(int nbTile) {
        List<Tile> res = new LinkedList<>();
        for (int i = 0; i < nbTile; i++) {
            res.add(draw());
        }
        return res;
    }

    private int getDrawn() { return remaining.size(); }
}

