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

	private TileItem[] items;
	private Tile[] neighbours;

	/**
	 * Create a Tile
	 * @param items an array of non-null items
	 * @param neighbours an array of nullable tile
	 */
	public Tile(TileItem[] items, Tile[] neighbours) {
		this.items = items;
		this.neighbours = neighbours;
	}

	/**
	 * Create a Tile with sample items and no neighbours
	 */
	public Tile() {
		this(TileItems.samples(CORNERS), new Tile[CORNERS]);
	}

	/**
	 * Get an item on the given index
	 * @param i an integer ranged between 0 and {@link fjorde.Tile#CORNERS}
	 * @return a non-null item
	 */
	public TileItem getItem(int i) {
		return items[i];
	}

	/**
	 * Get an item on the given cardinal point
	 * @param c a non-null cardinal point different of EAST and WEST
	 * @return a non-null item
	 */
	public TileItem getItem(Cardinal c) {
		// forbid EAST and WEST
		if (c == Cardinal.EAST || c == Cardinal.WEST) {
			throw new IllegalArgumentException();
		}

		// align indices
		int i = c.ordinal();
		if (i < 2) {
			return getItem(i);
		} else if (i < 6) {
			return getItem(i - 1);
		} else {
			return getItem(i - 2);
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
}
