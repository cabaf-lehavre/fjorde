package fjorde;

/**
 * A Tile contains multiple {@link fjorde.TileItem} and multiple neighbour Tile.
 * An absence of neighbour is notified by {@code null}.
 * @author Antoine CHAUVIN
 */
public class Tile {
	/**
	 * The constant number of corners a Tile has
	 */
	public static final int CORNERS = 6;

	private TileItem[] corners;
	private Tile[] neighbours;
	private PlayerItem item;

	/**
	 * Create a Tile
	 * @param corners an array of non-null corners
	 * @param neighbours an array of nullable tile
	 */
	public Tile(TileItem[] corners, Tile[] neighbours) {
		this.corners = corners;
		this.neighbours = neighbours;
	}

	/**
	 * Create a Tile without neighbours
	 * @param corners an array of non-null corners
	 */
	public Tile(TileItem[] corners) {
		this(corners, new Tile[corners.length]);
	}

	/**
	 * Get an item on the given index
	 * @param i an integer ranged between 0 and {@link fjorde.Tile#CORNERS}
	 * @return a non-null item
	 */
	public TileItem getCorner(int i) {
		return corners[i];
	}

	/**
	 * Get an item on the given cardinal point
	 * @param c a non-null cardinal point different of EAST and WEST
	 * @return a non-null item
	 */
	public TileItem getCorner(Cardinal c) {
		// forbid EAST and WEST
		if (c == Cardinal.EAST || c == Cardinal.WEST) {
			throw new IllegalArgumentException();
		}

		// align indices
		int i = c.ordinal();
		if (i < 2) {
			return getCorner(i);
		} else if (i < 6) {
			return getCorner(i - 1);
		} else {
			return getCorner(i - 2);
		}
	}

	/**
	 * Get a neighbour on the given index
	 * @param i an integer ranged between 0 and {@link fjorde.Tile#CORNERS}
	 * @return a nullable tile
	 */
	public Tile getNeighbour(int i) {
		return neighbours[i];
	}

	/**
	 * Get a neighbour on the given cardinal point
	 * @param c a non-null cardinal point different of NORTH and WEST
	 * @return a nullable tile
	 */
	public Tile getNeighbour(Cardinal c) {
		// forbid NORTH and SOUTH
		if (c == Cardinal.NORTH || c == Cardinal.SOUTH) {
			throw new IllegalArgumentException();
		}

		// align indices
		int i = c.ordinal();
		if (i < 4) {
			return getNeighbour(i - 1);
		} else {
			return getNeighbour(i - 2);
		}
	}

	/**
	 * Add a neighbour to this tile on the given index
	 * @param neighbour a non-null tile
	 * @param i an inetger ranged between 0 and {@link fjorde.Tile#CORNERS}
	 */
	public void addNeighbour(Tile neighbour, int i) {
		if (!canAddNeighbour(neighbour, i)) {
			throw new IllegalArgumentException();
		}

		this.neighbours[i] = neighbour;
	}

	private boolean canAddNeighbour(Tile neighbour, int i) {
		if (this.neighbours[i] != null) {
			return false;
		}

		// TODO
		return true;
	}

	/**
	 * Get the item present on this tile
	 * @return a nullable item
	 */
	public PlayerItem getItem() {
		return item;
	}

	/**
	 * Set the item present on this tile
	 * @param item a nullable item
	 */
	public void setItem(PlayerItem item) {
		this.item = item;
	}

	public String getSymbol() {
		return Tiles.newSymbol(this.corners);
	}

	public void rotate(int steps) {
		TileItem[] newCorners = new TileItem[this.corners.length];
		System.arraycopy(this.corners, this.corners.length - steps, newCorners, 0, steps);
		System.arraycopy(this.corners, 0, newCorners, steps, this.corners.length - steps);

		if (!Tiles.isValidCorners(newCorners)) {
			throw new IllegalStateException();
		}

		this.corners = newCorners;
	}

	public void rotate() {
		rotate(1);
	}
    public int getNbNeighbour(){return 2/*neighbours.length*/;}
    /**
     * Check a neighbour to put this tile and return a boolean
     * @param tileCurrent a non-null tile
     */
    public boolean canPutTile(Tile tileCurrent) {
        int nbNbNeighbour = tileCurrent.getNbNeighbour();
        System.out.print(nbNbNeighbour);
        if (nbNbNeighbour==0){return true;}
        if (nbNbNeighbour==1){return false;}

        for (int cpt1=0;cpt1<=nbNbNeighbour;cpt1++) {
            for (int cpt2=0;cpt2<=nbNbNeighbour;cpt2++) {
                for (int cpt3=0;cpt3<=7;cpt3++) {
                    switch (nbNbNeighbour) {
                        case 2:
                            if (tileCurrent.getCorner(cpt1) == tileCurrent.getNeighbour(cpt2).getCorner(cpt3) &&
                                    tileCurrent.getCorner((cpt1 + 1) % 7) == tileCurrent.getNeighbour((cpt2 + 1) % 7).getCorner((cpt3 + 1) % 7)){
                                return true;
                            }
                        case 3:
                            if (tileCurrent.getCorner(cpt1) == tileCurrent.getNeighbour(cpt2).getCorner(cpt3) &&
                                    tileCurrent.getCorner((cpt1 + 1) % 7) == tileCurrent.getNeighbour((cpt2 + 1) % 7).getCorner((cpt3 + 1) % 7)&&
                                    tileCurrent.getCorner((cpt1 + 2) % 7) == tileCurrent.getNeighbour((cpt2 + 2) % 7).getCorner((cpt3 + 3) % 7)){
                                return true;
                            }
                        case 4:
                            if (tileCurrent.getCorner(cpt1) == tileCurrent.getNeighbour(cpt2).getCorner(cpt3) &&
                                    tileCurrent.getCorner((cpt1 + 1) % 7) == tileCurrent.getNeighbour((cpt2 + 1) % 7).getCorner((cpt3 + 1) % 7)&&
                                    tileCurrent.getCorner((cpt1 + 2) % 7) == tileCurrent.getNeighbour((cpt2 + 2) % 7).getCorner((cpt3 + 2) % 7)&&
                                    tileCurrent.getCorner((cpt1 + 3) % 7) == tileCurrent.getNeighbour((cpt2 + 3) % 7).getCorner((cpt3 + 3) % 7)){
                                return true;
                            }
                        case 5:
                            if (tileCurrent.getCorner(cpt1) == tileCurrent.getNeighbour(cpt2).getCorner(cpt3) &&
                                    tileCurrent.getCorner((cpt1 + 1) % 7) == tileCurrent.getNeighbour((cpt2 + 1) % 7).getCorner((cpt3 + 1) % 7)&&
                                    tileCurrent.getCorner((cpt1 + 2) % 7) == tileCurrent.getNeighbour((cpt2 + 2) % 7).getCorner((cpt3 + 2) % 7)&&
                                    tileCurrent.getCorner((cpt1 + 3) % 7) == tileCurrent.getNeighbour((cpt2 + 3) % 7).getCorner((cpt3 + 3) % 7)&&
                                    tileCurrent.getCorner((cpt1 + 4) % 7) == tileCurrent.getNeighbour((cpt2 + 4) % 7).getCorner((cpt3 + 4) % 7)){
                                return true;
                            }
                        case 6:
                            if (tileCurrent.getCorner(cpt1) == tileCurrent.getNeighbour(cpt2).getCorner(cpt3) &&
                                    tileCurrent.getCorner((cpt1 + 1) % 7) == tileCurrent.getNeighbour((cpt2 + 1) % 7).getCorner((cpt3 + 1) % 7)&&
                                    tileCurrent.getCorner((cpt1 + 2) % 7) == tileCurrent.getNeighbour((cpt2 + 2) % 7).getCorner((cpt3 + 2) % 7)&&
                                    tileCurrent.getCorner((cpt1 + 3) % 7) == tileCurrent.getNeighbour((cpt2 + 3) % 7).getCorner((cpt3 + 3) % 7)&&
                                    tileCurrent.getCorner((cpt1 + 4) % 7) == tileCurrent.getNeighbour((cpt2 + 4) % 7).getCorner((cpt3 + 4) % 7)&&
                                    tileCurrent.getCorner((cpt1 + 5) % 7) == tileCurrent.getNeighbour((cpt2 + 5) % 7).getCorner((cpt3 + 5) % 7)){
                                return true;
                            }
                    }
                }
            }
        }
        return false;
    }
}
