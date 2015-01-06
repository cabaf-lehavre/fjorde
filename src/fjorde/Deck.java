package fjorde;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alexandre BAPTISTE
 * @author Antoine CHAUVIN
 */
public class Deck {

    private List<Tile> remaining;

    public Deck(List<Tile> remaining) {
        this.remaining = new LinkedList<Tile>(remaining);
        Collections.shuffle(this.remaining);
    }

    public Deck(int size) {
        // no need to shuffle a list of random tiles
        this.remaining = Tiles.samples(size);
    }

    // Drawn last Tile in the deck
    public Tile draw() {
        return remaining.remove(0);
    }

    private List<Tile> draw(int nbTile) {
        List<Tile> res = new LinkedList<Tile>();
        for (int i = 0; i < nbTile; i++) {
            res.add(draw());
        }
        return res;
    }

    private int getRemainingTiles() { return remaining.size(); }
}

