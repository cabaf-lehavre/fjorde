package fjorde;

import java.io.File;
import java.util.*;

/**
 * Tiles contains utilities related to {@link fjorde.Tile}.
 * @author Antoine CHAUVIN
 */
public final class Tiles {
    private Tiles() {}

    private final static List<String> SYMBOLS;

    static {
        String path = System.getProperty("fjorde.img.tiles", "img/tiles/");
        File baseDir = new File(path);
        String[] children = baseDir.list();
        if (children == null) {
            throw new Error("COULDN'T FIND IMAGE DIRECTORY");
        }

        SYMBOLS = Collections.unmodifiableList(Arrays.asList(children));
    }

    /**
     * Randomly generate a valid tile symbol
     * @param random a non-null random generator
     * @return a non-null string representing
     */
    public static String sampleSymbol(Random random) {
        int i = random.nextInt(SYMBOLS.size());
        return SYMBOLS.get(i);
    }

    /**
     * Generate a tile by a given symbol
     * @param symbol a non-null string representing the symbol
     * @return a non-null tile
     */
    public static Tile fromSymbol(String symbol) {
        TileItem[] corners = new TileItem[symbol.length()];
        for (int i = 0; i < symbol.length(); i++) {
            char c = symbol.charAt(i);
            corners[i] = TileItems.create(c);
        }

        return new Tile(corners);
    }

    /**
     * Randomly create a tile
     * @param random a non-null random generator
     * @return a non-null tile
     */
    public static Tile sample(Random random) {
        return fromSymbol(sampleSymbol(random));
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
