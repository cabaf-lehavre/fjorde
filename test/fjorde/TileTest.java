package fjorde;

import java.util.Random;

import static fjorde.TileItems.MOUNTAIN;
import static unit.Assert.assertEquals;

public class TileTest {
    public static void main(String[] args) {
        // create a tile composed of mountains only
        Tile tile = Tiles.of(MOUNTAIN, MOUNTAIN, MOUNTAIN,
                             MOUNTAIN, MOUNTAIN, MOUNTAIN);

        assertEquals(tile.getSymbol(), "MMMMMM", "wrong symbol");

        Tile sample = Tiles.sample(new Random(System.nanoTime()));

        System.out.println("success");
    }
}
