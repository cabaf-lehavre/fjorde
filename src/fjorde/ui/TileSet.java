package fjorde.ui;

import fjorde.Cardinal;
import fjorde.Tile;

import java.util.Arrays;
import java.util.List;

/**
 * @author Antoine CHAUVIN INFOB1
 */
public class TileSet {
    private Tile[][] tiles;

    public TileSet(int width, int height) {
        this.tiles = new Tile[width][height];
    }

    public int getWidth() {
        return tiles.length;
    }

    public int getHeight() {
        return tiles[0].length;
    }

    private boolean inBounds(int x, int y) {
        return x >= 0 && x < getWidth()
            && y >= 0 && y < getHeight();
    }

    public Tile tryGet(int x, int y) {
        return tiles[x][y];
    }

    public Tile get(int x, int y) {
        Tile tile = tiles[x][y];
        if (tile == null) {
            throw new IllegalStateException();
        }
        return tile;
    }

    public Tile weakGet(int x, int y) {
        return inBounds(x, y) ? tryGet(x, y) : null;
    }

    public boolean present(int x, int y) {
        return inBounds(x, y) && tryGet(x, y) != null;
    }

    public void set(int x, int y, Tile tile) {
        tiles[x][y] = tile;
        // todo neighbours

        List<Tile> neighbours = around(x, y);
        for (int i = 0; i < neighbours.size(); i++) {
            Tile neighbour = neighbours.get(i);
            if (neighbour == null) {
                continue;
            }

            int j = Cardinal.neighbourIndexOpposite(i);

            // from A to B
            tile.addNeighbour(neighbour, i);
            // from B to A
            neighbour.addNeighbour(tile, j);
        }
    }

    private List<Tile> around(int x, int y) {
        // auto-correct neighbour ordinates
        int d = x % 2;

        int neX = x - 1, neY = y + d;
        int eX = x, eY = y + 1;
        int seX = x + 1, seY = y + d;
        int swX = x + 1, swY = y - 1 + d;
        int wX = x, wY = y + 1;
        int nwX = x - 1, nwY = y - 1 + d;
        Tile ne = weakGet(neX, neY);
        Tile e  = weakGet(eX, eY);
        Tile se = weakGet(seX, seY);
        Tile sw = weakGet(swX, swY);
        Tile w  = weakGet(wX, wY);
        Tile nw = weakGet(nwX, nwY);

        return Arrays.asList(ne, e, se, sw, w, nw);
    }

    public boolean trySet(int x, int y, Tile tile) {
        if (!present(x, y)) {
            set(x, y, tile);
            return true;
        }
        return false;
    }
}
