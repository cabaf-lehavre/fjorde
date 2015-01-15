package fjorde.ui;

import fjorde.Cardinal;
import fjorde.Tile;

import java.util.Arrays;
import java.util.List;

/**
 * @author Antoine CHAUVIN INFOB1
 * @author Cyril Alves
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

    /**
     * Check a neighbour to put this tile and return a boolean
     * @param tileCurrent a non-null tile
     */
    public boolean canPutTile(Tile tileCurrent) {

        boolean bool[]=new boolean[Tile.CORNERS];
        boolean boolCheck[]=new boolean[Tile.CORNERS];
        int nbNeighbour=0;
        int nbNeighbourCheck=0;

        for (int cptBool=0;cptBool<Tile.CORNERS;cptBool++){
            if (tileCurrent.getNeighbour(cptBool) != null){
                bool[cptBool]=true;
                nbNeighbour++;
            }
            else {
                bool[cptBool]=false;
            }
        }

        for (int intNeighbour = 0; intNeighbour < Tile.CORNERS; intNeighbour++) {
            if (tileCurrent.getNeighbour(intNeighbour) != null) {
                if (intNeighbour == 0) {
                    if (tileCurrent.getNeighbour(intNeighbour).getCorner(4) == tileCurrent.getCorner(0) &&
                            tileCurrent.getNeighbour(intNeighbour).getCorner(3) == tileCurrent.getCorner(1)) {
                        boolCheck[intNeighbour]=true;
                    }
                    else {boolCheck[intNeighbour]=false;}
                }
                if (intNeighbour == 1) {
                    if (tileCurrent.getNeighbour(intNeighbour).getCorner(5) == tileCurrent.getCorner(1) &&
                            tileCurrent.getNeighbour(intNeighbour).getCorner(4) == tileCurrent.getCorner(2)) {
                        boolCheck[intNeighbour]=true;
                    }
                    else {boolCheck[intNeighbour]=false;}
                }
                if (intNeighbour == 2) {
                    if (tileCurrent.getNeighbour(intNeighbour).getCorner(0) == tileCurrent.getCorner(2) &&
                            tileCurrent.getNeighbour(intNeighbour).getCorner(5) == tileCurrent.getCorner(3)) {
                        boolCheck[intNeighbour]=true;
                    }
                    else {boolCheck[intNeighbour]=false;}
                }
                if (intNeighbour == 3) {
                    if (tileCurrent.getNeighbour(intNeighbour).getCorner(1) == tileCurrent.getCorner(3) &&
                            tileCurrent.getNeighbour(intNeighbour).getCorner(0) == tileCurrent.getCorner(4)) {
                        boolCheck[intNeighbour]=true;
                    }
                    else {boolCheck[intNeighbour]=false;}
                }
                if (intNeighbour == 4) {
                    if (tileCurrent.getNeighbour(intNeighbour).getCorner(2) == tileCurrent.getCorner(4) &&
                            tileCurrent.getNeighbour(intNeighbour).getCorner(1) == tileCurrent.getCorner(5)) {
                        boolCheck[intNeighbour]=true;
                    }
                    else {boolCheck[intNeighbour]=false;}
                }
                if (intNeighbour == 5) {
                    if (tileCurrent.getNeighbour(intNeighbour).getCorner(3) == tileCurrent.getCorner(5) &&
                            tileCurrent.getNeighbour(intNeighbour).getCorner(2) == tileCurrent.getCorner(0)) {
                        boolCheck[intNeighbour]=true;
                    }
                    else {boolCheck[intNeighbour]=false;}
                }
            }
        }
        for (int cptTab=0;cptTab<Tile.CORNERS;cptTab++){
            if (bool[cptTab]==bool[cptTab]){
                nbNeighbourCheck++;
            }
        }
        if (nbNeighbour==nbNeighbourCheck){
            return true;
        }
        return false;
    }
}
