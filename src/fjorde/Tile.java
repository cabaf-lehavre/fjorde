package fjorde;

public class Tile {
	public static final int CORNERS = 6;

	private TileItem[] items;
	private Tile[] neighbours;

	public Tile(TileItem[] items, Tile[] neighbours) {
		this.items = items;
		this.neighbours = neighbours;
	}

	public Tile() {
		this(TileItems.samples(CORNERS), new Tile[CORNERS]);
	}

	public TileItem getItem(int i) {
		return items[i];
	}

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

	public Tile getNeighbour(int i) {
		return neighbours[i];
	}

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
}
