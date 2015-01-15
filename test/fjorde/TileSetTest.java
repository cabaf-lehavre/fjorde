package fjorde;

import fjorde.ui.TileSet;
import unit.Assert;

import java.util.Random;

public class TileSetTest {
    public static void main(String[] args) {
        testSet();

        System.out.println("success");
    }

    public static void testSet() {
        Random rand = new Random(System.nanoTime());
        TileSet ts = new TileSet(50, 50);

        Tile a = Tiles.sample(rand);
        Tile b = Tiles.sample(rand);
        Tile c = Tiles.sample(rand);

        ts.set(0, 0, a);
        ts.set(1, 0, b);
        ts.set(2, 1, c);

        Assert.assertSameIdent(a, b.getNeighbour(Cardinal.NORTH_WEST), "wrong neighbour");
        Assert.assertSameIdent(b, a.getNeighbour(Cardinal.SOUTH_EAST), "wrong neighbour");

        Assert.assertSameIdent(c, b.getNeighbour(Cardinal.SOUTH_EAST), "wrong neighbour");
        Assert.assertSameIdent(b, c.getNeighbour(Cardinal.NORTH_WEST), "wrong neighbour");
    }
}
