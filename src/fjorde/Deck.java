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

    public Tile drawAt(int i) {
        return remaining.remove(i);
    }

    public Tile peek() {
        return remaining.get(0);
    }

    public void deposit(Tile tile){
        remaining.add(0, tile);
    }

    private List<Tile> draw(int nbTile) {
        List<Tile> res = new LinkedList<Tile>();
        for (int i = 0; i < nbTile; i++) {
            res.add(draw());
        }
        return res;
    }

    public Tile getTile(int i) {
        return remaining.get(i);
    }

    public int getSize() { return remaining.size(); }
}

