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

    public boolean present(int x, int y) {
        return inBounds(x, y) && tryGet(x, y) != null;
    }

    public void set(int x, int y, Tile tile) {
        tiles[x][y] = tile;
        // todo neighbours
    }

    public boolean trySet(int x, int y, Tile tile) {
        if (!present(x, y)) {
            set(x, y, tile);
            return true;
        }
        return false;
    }
}
