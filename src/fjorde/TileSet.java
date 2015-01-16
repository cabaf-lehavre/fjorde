package fjorde;

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

    public boolean inBounds(int x, int y) {
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
    public String getStateTable(){
        String retour="";
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (tiles[i][j] != null) {
                    retour += "ts.init(" + i + "," + "Tiles.of(";
                    for (int x = 0; x < 6; x++) {
                        retour += TileItems.getValue(tiles[i][j].getCorner(x).getSymbol().charAt(0));
                        if (x != 5) retour += ",";
                    }
                    retour += "));\n";
                }
            }
        }
        return retour;
    }
    public String tabToString(int[] tab){
        String s="";
        //{20 + vX, 40 + vX, 40 + vX, 20 + vX, 0 + vX, 0 + vX}
        s+="{";
        for(int i=0;i<tab.length;i++) {
            s += tab[i];
            if(tab.length-1!=i)s +=",";
        }
        s+="}";
        return s;
    }
    public Tile weakGet(int x, int y) {
        return inBounds(x, y) ? tryGet(x, y) : null;
    }

    public boolean present(int x, int y) {
        return inBounds(x, y) && tryGet(x, y) != null;
    }

    /**
     * @deprecated Some kind of backdoor method initializing a tile on the set
     *             Please use {@link TileSet#set(int, int, fjorde.Tile)}
     */
    @Deprecated
    public void init(int x, int y, Tile tile) {
        tiles[x][y] = tile;
        addNeighbours(x, y, tile);

    }

    public boolean set(int x, int y, Tile tile) {
        addNeighbours(x, y, tile);
        System.out.println(getStateTable());
        if (!canPutTile(tile)) {
            tile.clearNeighbours();
            return false;
        }

        tiles[x][y] = tile;
        return true;
    }

    public void addNeighbours(int x, int y, Tile tile) {
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
        return !present(x, y) && set(x, y, tile);
    }

    public int[][] aroundPosition(int x, int y) {
        // auto-correct neighbour ordinates
        int d = x % 2;

        int[][] res = new int[6][];

        res[0] = new int[]{x - 1, y + d};
        res[1] = new int[]{x, y + 1};
        res[2] = new int[]{x + 1, y + d};
        res[3] = new int[]{x + 1, y - 1 + d};
        res[4] = new int[]{x, y - 1};
        res[5] = new int[]{x - 1, y - 1 + d};

        return res;
    }
    /**
     * Check a neighbour to put this tile and return a boolean
     * @param tileCurrent a non-null tile
     */
    public boolean canPutTile(Tile tileCurrent) {

        boolean bool[] = new boolean[Tile.CORNERS];
        boolean boolCheck[] = new boolean[Tile.CORNERS];
        int nbNeighbour = 0;
        int nbNeighbourCheck = 0;
        boolean noSea=false;
        for (int cptBool = 0; cptBool < Tile.CORNERS; cptBool++) {
            if (tileCurrent.getNeighbour(cptBool) != null) {
                bool[cptBool] = true;
                nbNeighbour++;
            } else {
                bool[cptBool] = false;
            }
        }

        for (int intNeighbour = 0; intNeighbour < Tile.CORNERS; intNeighbour++) {

            if (tileCurrent.getNeighbour(intNeighbour) != null) {


                if (intNeighbour == 0) {
                    if (tileCurrent.getNeighbour(intNeighbour).getCorner(4).getSymbol().equals(tileCurrent.getCorner(0).getSymbol()) &&
                            tileCurrent.getNeighbour(intNeighbour).getCorner(3).getSymbol().equals(tileCurrent.getCorner(1).getSymbol())) {
                        if(!tileCurrent.getNeighbour(intNeighbour).getCorner(4).getSymbol().equals("S")) noSea=true;
                        if(!tileCurrent.getNeighbour(intNeighbour).getCorner(3).getSymbol().equals("S")) noSea=true;
                        boolCheck[intNeighbour] = true;
                    } else {
                        boolCheck[intNeighbour] = false;
                    }
                }
                if (intNeighbour == 1) {
                    if (tileCurrent.getNeighbour(intNeighbour).getCorner(5).getSymbol().equals(tileCurrent.getCorner(1).getSymbol()) &&
                            tileCurrent.getNeighbour(intNeighbour).getCorner(4).getSymbol().equals(tileCurrent.getCorner(2).getSymbol())) {
                        if(!tileCurrent.getNeighbour(intNeighbour).getCorner(4).getSymbol().equals("S")) noSea=true;
                        if(!tileCurrent.getNeighbour(intNeighbour).getCorner(5).getSymbol().equals("S")) noSea=true;
                        boolCheck[intNeighbour] = true;
                    } else {
                        boolCheck[intNeighbour] = false;
                    }
                }
                if (intNeighbour == 2) {
                    if (tileCurrent.getNeighbour(intNeighbour).getCorner(0).getSymbol().equals(tileCurrent.getCorner(2).getSymbol()) &&
                            tileCurrent.getNeighbour(intNeighbour).getCorner(5).getSymbol().equals(tileCurrent.getCorner(3).getSymbol())) {
                        if(!tileCurrent.getNeighbour(intNeighbour).getCorner(0).getSymbol().equals("S")) noSea=true;
                        if(!tileCurrent.getNeighbour(intNeighbour).getCorner(5).getSymbol().equals("S")) noSea=true;

                        boolCheck[intNeighbour] = true;
                    } else {
                        boolCheck[intNeighbour] = false;
                    }
                }
                if (intNeighbour == 3) {
                    if (tileCurrent.getNeighbour(intNeighbour).getCorner(1).getSymbol().equals(tileCurrent.getCorner(3).getSymbol()) &&
                            tileCurrent.getNeighbour(intNeighbour).getCorner(0).getSymbol().equals(tileCurrent.getCorner(4).getSymbol())) {
                        boolCheck[intNeighbour] = true;
                        if(!tileCurrent.getNeighbour(intNeighbour).getCorner(0).getSymbol().equals("S")) noSea=true;
                        if(!tileCurrent.getNeighbour(intNeighbour).getCorner(1).getSymbol().equals("S")) noSea=true;

                    } else {
                        boolCheck[intNeighbour] = false;
                    }
                }
                if (intNeighbour == 4) {
                    if (tileCurrent.getNeighbour(intNeighbour).getCorner(2).getSymbol().equals(tileCurrent.getCorner(4).getSymbol()) &&
                            tileCurrent.getNeighbour(intNeighbour).getCorner(1).getSymbol().equals(tileCurrent.getCorner(5).getSymbol())) {
                        boolCheck[intNeighbour] = true;
                        if(!tileCurrent.getNeighbour(intNeighbour).getCorner(2).getSymbol().equals("S")) noSea=true;
                        if(!tileCurrent.getNeighbour(intNeighbour).getCorner(1).getSymbol().equals("S")) noSea=true;

                    } else {
                        boolCheck[intNeighbour] = false;
                    }
                }
                if (intNeighbour == 5) {
                    if (tileCurrent.getNeighbour(intNeighbour).getCorner(3).getSymbol().equals(tileCurrent.getCorner(5).getSymbol()) &&
                            tileCurrent.getNeighbour(intNeighbour).getCorner(2).getSymbol().equals(tileCurrent.getCorner(0).getSymbol())) {
                        boolCheck[intNeighbour] = true;
                        if(!tileCurrent.getNeighbour(intNeighbour).getCorner(3).getSymbol().equals("S")) noSea=true;
                        if(!tileCurrent.getNeighbour(intNeighbour).getCorner(2).getSymbol().equals("S")) noSea=true;

                    } else {
                        boolCheck[intNeighbour] = false;
                    }
                }
            }
        }
        for (int cptTab = 0; cptTab < Tile.CORNERS; cptTab++) {
            if (boolCheck[cptTab] == bool[cptTab]) {
                if (boolCheck[cptTab]==true)nbNeighbourCheck++;
            }
        }
        if (nbNeighbour == nbNeighbourCheck) {
            if (nbNeighbour<2 )return false;
            return noSea;
        }
        return false;
    }
}