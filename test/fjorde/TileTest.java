package fjorde;

import static fjorde.TileItems.MOUNTAIN;
import static unit.Assert.assertEquals;

public class TileTest {
    public static void main(String[] args) {
        // create a tile composed of mountains only
        Tile tile = Tiles.of(MOUNTAIN, MOUNTAIN, MOUNTAIN,
                             MOUNTAIN, MOUNTAIN, MOUNTAIN);

        assertEquals(tile.getSymbol(), "MMMMMM", "wrong symbol");

        System.out.println("success");
    }
}
