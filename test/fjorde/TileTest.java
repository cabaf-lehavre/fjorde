package fjorde;

import java.util.Random;

import static fjorde.TileItems.*;
import static unit.Assert.assertEquals;

public class TileTest {
    public static void main(String[] args) {
        testSymbolGeneration();
        testRotation();
        testSampling();

        System.out.println("success");
    }

    private static void testSymbolGeneration() {
        Tile tile = Tiles.of(MOUNTAIN, MOUNTAIN, MOUNTAIN,
                MOUNTAIN, MOUNTAIN, MOUNTAIN);

        assertEquals(tile.getSymbol(), "MMMMMM", "wrong symbol");
    }

    private static void testRotation() {
        Tile tile = Tiles.of(MOUNTAIN, MOUNTAIN, MOUNTAIN,
                MOUNTAIN, MOUNTAIN, MOUNTAIN);
        tile.rotate();
        assertEquals(tile.getSymbol(), "MMMMMM", "wrong symbol");

        Tile tile2 = Tiles.of(PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, SEA);
        tile2.rotate();
        assertEquals(tile2.getSymbol(), "SPPPPP", "wrong symbol");
        tile2.rotate();
        assertEquals(tile2.getSymbol(), "PSPPPP", "wrong symbol");

        Tile tile3 = Tiles.of(PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, SEA);
        tile3.rotate(2);
        assertEquals(tile3.getSymbol(), tile2.getSymbol(), "wrong symbol");
    }

    private static void testSampling() {
        Tiles.sample(new Random(System.nanoTime()));
        // should not throw an exception
    }
}
