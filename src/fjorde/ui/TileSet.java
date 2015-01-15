package fjorde.ui;

import fjorde.Cardinal;
import fjorde.Tile;

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

        int[][] positions = aroundPosition(x, y);
        for (int i = 0; i < positions.length; i++) {
            int[] pos = positions[i];

            Tile neighbour = weakGet(pos[0], pos[1]);
            if (neighbour == null) {
                continue;
            }

            tile.addNeighbour(neighbour, i);
            neighbour.addNeighbour(tile, Cardinal.neighbourIndexOpposite(i));
        }
    }

    public boolean trySet(int x, int y, Tile tile) {
        if (!present(x, y)) {
            set(x, y, tile);
            return true;
        }
        return false;
    }
    
    public int[][] aroundPosition(int x, int y) {
        // auto-correct neighbour ordinates
        int d = x % 2;
        
        int[][] res = new int[6][];
        
        res[0] = new int[]{x - 1, y + d};
        res[1] = new int[]{x, y + 1};
        res[2] = new int[]{x + 1, y + d};
        res[3] = new int[]{x + 1, y - 1 + d};
        res[4] = new int[]{x, y + 1};
        res[5] = new int[]{x - 1, y - 1 + d};
        
        return res;
    }
}
