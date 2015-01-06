package fjorde;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Tiles contains utilities related to {@link fjorde.Tile}.
 * @author Antoine CHAUVIN
 */
public final class Tiles {
    private Tiles() {}

    /**
     * Randomly create a tile
     * @param random a non-null random generator
     * @return a non-null tile
     */
    public static Tile sample(Random random) {
        return new Tile(random);
    }

    /**
     * Randomly create a list of tiles
     * @param n the size of the resulting list
     * @param random a non-null random generator
     * @return a non-null list of non-null tiles
     */
    public static List<Tile> samples(int n, Random random) {
        List<Tile> samples = new LinkedList<Tile>();
        for (int i = 0; i < n; i++) {
            samples.add(sample(random));
        }
        return samples;
    }

    /**
     * Randomly create a list of tiles
     * @param n the size of the resulting list
     * @return a non-null list of non-null tiles
     */
    public static List<Tile> samples(int n) {
        return samples(n, new Random(System.nanoTime()));
    }
}
