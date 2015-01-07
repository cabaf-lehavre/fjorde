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
     * Create a tile without neighbours
     * @param corners a non-null array of non-null items
     * @return a non-null tile
     */
    public static Tile of(TileItem... corners) {
        if (corners.length != Tile.CORNERS) {
            throw new IllegalArgumentException();
        }
        return new Tile(corners, new Tile[Tile.CORNERS]);
    }

    /**
     * Create a tile without neighbours using {@link fjorde.TileItems#create(int)}
     * @param indexes a non-null array of integer
     * @return a non-null tile
     */
    public static Tile of(int... indexes) {
        TileItem[] corners = new TileItem[indexes.length];
        for (int i = 0; i < indexes.length; i++) {
            corners[i] = TileItems.create(indexes[i]);
        }

        return of(corners);
    }

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
